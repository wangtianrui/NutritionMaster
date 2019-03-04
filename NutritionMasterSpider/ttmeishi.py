from requests.exceptions import RequestException
import requests
import csv
from lxml import etree
import time
from functions import get_proxy

#tt网页
base_url = "http://www.ttmeishi.com/CaiXi/ZiHanDaoHan/"
#网页前面的前缀
base_menu_url = "http://www.ttmeishi.com"

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36'
}
#所有的菜谱
total_menu=[]
#现爬的代理池
proxy_list = get_proxy.get_proxys(10)

def get_html(url):
    try:
        proxy = get_proxy.test_proxy(proxy_list)
        r = requests.get(url, headers=headers, proxies= proxy, timeout= 5)
        if r.status_code == 200:
            r.encoding = r.apparent_encoding
            s = etree.HTML(r.text)
            print("菜谱详情请求成功")
            return s
    except RequestException as e:
        print("-----地址错误-----", e)


def get_page(page):#从2开始
    try:
        if page != 1:
            re = requests.get(base_url + "list%d.htm" %page, headers= headers, timeout= 5)
            if re.status_code == 200:
                print("一页ok")
                return re.text
            else:
                print(re.status_code)
        else:
            re = requests.get(base_url, headers = headers, timeout= 5)
            if re.status_code == 200:
                print("一页ok")
                return re.text
            else:
                print(re.status_code)
    except RequestException as e:
        print("asd", e)

def get_urls(html):
    menu=[]
    try:
        s = etree.HTML(html)
        urls = s.xpath('//div[@id="content" and @class="content"]'
                      '//li[@class="cx_liebiao_li"]'
                      '//a/@href')
        for url in urls:
            url = base_menu_url + url
            menu.append(url)
        print(menu)
        return menu
    except RequestException as e:
        print("-----获取菜谱失败-----", e)

#获取菜谱得网址
def get_info(urls):
    total_info = []
    index = 1
    for url in urls:
        if index % 10 == 0:
            time.sleep(10)
            print("大睡" + str(index))
        else:
            time.sleep(2)
            print("小睡" + str(index))
        try:
            s = get_html(url)
            dic = {
                "菜名": "",
                "分类": "",
                "口味": "",
                "食材": "",
                "主要工艺": "",
                "制作时间": "",
                "做法": "",
                "图片url": "",
            }
            dic["菜名"] = s.xpath('//div[@id= "content" and @class= "content"]'
                                '//h1/text()')[0]
            classification_info1 = s.xpath('//ul[@class= "fenlei_ul"]//li'
                                           '//span[@class="fenlei_li_name"]'
                                           '//a/text()')
            classification_info2 = s.xpath('//ul[@class= "fenlei_ul"]//li'
                                           '//span[@class="fenlei_li_sm"]/text()')
            for i in range(len(classification_info1)):
                classification_info2[i] = classification_info2[i] + ":" \
                                          + classification_info1[i]
            # 分类里有一堆，所以这里采用遍历分开
            for classification in classification_info2:
                if classification[0:2] == "分类":
                    dic["分类"] = dic["分类"] + "," + classification[3:]
                    dic["分类"].strip(",")
                elif classification[0:4] == "菜品口味":
                    dic["口味"] = classification[5:]
                elif classification[2:4] == "时间":
                    dic["制作时间"] = classification[5:]
                elif classification[2:4] == "工艺":
                    dic["主要工艺"] = classification[5:]
                elif classification[0:2] == "工艺":
                    dic["主要工艺"] = classification[3:]
                elif classification[2:4] == "难度":
                    pass
                else:
                    dic["食材"] = dic["食材"] + "," + classification
            # step_info是菜谱的制作步骤的临时储存，下面好整理
            step_info1 = s.xpath('//div[@class="c_bz_neirong_b0ah"]/text()')
            step_info2 = s.xpath('//div[@class="c_buzhou cbox"]/text()')
            for i in range(len(step_info1)):
                step_info1[i] = str(i + 1) + "." + step_info1[i]
            for i in range(len(step_info2)):
                step_info2[i] = step_info2[i].strip()
            dic["做法"] = step_info1 + step_info2
            dic["图片url"] = s.xpath('//div[@class="cbox c_img"]//img/@src')
            total_info.append(dic)
            print("done" + str(index))
            index = index + 1
        except:
            print(dic["菜名"]+"error")
    return total_info

#最终几百道菜的菜谱

#写入文件
def write_csv(menu_list):
    try:
        with open(r"E:\datapy\脏腑调理\自汗盗汗.csv", "w", newline="") as csvfile:
            index = 1
            fieldnames = ["菜名", "分类", "口味", "食材", "主要工艺", "制作时间", "做法", "图片url"]
            writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
            writer.writeheader()
            for menu in menu_list:
                try:
                    writer.writerow(menu)
                    print("write" + str(index))
                    index = index + 1
                except Exception as e:
                    print("文件操作异常，写入失败", e)
    except:
        print("文件操作异常，打开失败")

if __name__ == '__main__':
    urls = []
    for i in range(4):
        time.sleep(1)
        print("主函数睡" + str(i))
        html = get_page(i+1)
        urls = get_urls(html) + urls
    m = get_info(urls)
    write_csv(m)