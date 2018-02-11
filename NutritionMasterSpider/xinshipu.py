from functions import get_selector, send_request
from requests import RequestException
import time
from functions import wtrte_csv

ttt = ["zaocan", "wucan", "wancan"]
base_url = "https://www.meishij.net/chufang/diy/"

def get_urls(menu_url):
    """
    获取界面上的菜的url
    :param menu_url: 某类食谱
    :return: 该类食谱的所有菜的url
    """
    urls_list = []
    for i in range(11):
        time.sleep(1)
        try:
            url = menu_url + str(i + 1)
            print(url)
            s = get_selector.get_selector(send_request.send_requests(url))
            urls = s.xpath('//div[@class="listtyle1"]//a/@href')
            urls_list.extend(urls)
            print("page"+str(i), "done")
        except Exception as e:
            print("打开失败", e)
    return urls_list

def get_info(url):
    """
    获取详细内容
    :param url: 菜品的url
    :return: 返回的字典
    """
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
    try:
        time.sleep(1)
        print("open", url)
        s = get_selector.get_selector(send_request.send_requests(url))
        dic["图片url"] = s.xpath('//div[@class="cp_headerimg_w"]//img/@src')[0]
        dic["菜名"] = s.xpath('//h1[@class="title"]//a/text()')[0]
        dic["分类"] = s.xpath('//dl[@class="yj_tags clearfix"]//a/text()')
        dic["主要工艺"] = s.xpath('//li[@class="w127"]//a/text()')[0]
        dic["口味"] = s.xpath('//li[@class="w127 bb0"]//a/text()')[0]
        dic["制作时间"] = s.xpath('//li[@class="w270 bb0 br0"]//div[@class="processing_w"]//a/text()')[0]
        zhuliao = s.xpath('//div[@class="c"]//h4/child::*/text()')
        fuliao = s.xpath('//div[@class="yl fuliao clearfix"]//ul[@class="clearfix"]/descendant::*/text()')
        cailiao = []
        for i in range(len(zhuliao)):
            if i % 2 == 0:
                temp = zhuliao[i] + ":" + zhuliao[i + 1]
                cailiao.append(temp)
        for i in range(len(fuliao)):
            if i % 2 == 0:
                temp = fuliao[i] + ":" + fuliao[i + 1]
                cailiao.append(temp)
        dic["食材"] = cailiao
        steps = s.xpath('//div[@class="editnew edit"]//div//p/text()')
        for i in range(len(steps)):
            steps[i] = str(i + 1) + steps[i]
        dic["做法"] = steps
        print(dic.get("菜名"), "done")
    except Exception as e:
        print("获取菜失败", e)
    return dic

if __name__ == '__main__':
    path = r"E:\datapy\心食谱\\"
    for i in ttt:
        time.sleep(1)
        menu_list = get_urls(base_url + i + "/?&page=")
        dic_list = []
        for menu in menu_list:
            time.sleep(1)
            dic_list.append(get_info(menu))
        wtrte_csv.write_csv(dic_list, path + i + ".csv" )
        print(i, "done")