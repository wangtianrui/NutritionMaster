# -*- coding:utf-8 -*-
from functions import send_request, get_selector
import os

author_urls = {
    "欧阳询": "http://www.yac8.com/news/?list_refer-theme-%C5%B7%D1%F4%D1%AF_",
    "王羲之": "http://www.yac8.com/news/?list_refer-theme-%CD%F5%F4%CB%D6%AE_",
    "颜真卿": "http://www.yac8.com/news/?list_refer-theme-%D1%D5%D5%E6%C7%E4_",
    "文徵明": "http://www.yac8.com/news/?list_refer-theme-%CE%C4%E1%E7%C3%F7_",
    "赵孟頫": "http://www.yac8.com/news/?list_refer-theme-%D5%D4%C3%CF%EE%5C_",
    "柳公权": "http://www.yac8.com/news/?list_refer-theme-%C1%F8%B9%AB%C8%A8_"
}

base_url = "http://www.yac8.com"

test_dic = {
    "欧阳询": "http://www.yac8.com/news/?list_refer-theme-%C5%B7%D1%F4%D1%AF_",
}

def get_urls(all_author):
    """
    获取书法家的所有文章
    :param all_author:
    :return:
    """
    all_author_dic = {}
    for name in all_author:
        try:
            page = 1
            url = all_author[name] + "{index}.html".format(index=page)
            # print(url)
            s = get_selector.get_selector(send_request.send_requests(url))
            result = s.xpath('//div[@class="navBtn font1_2"]/text()')[0]
            page_max = result[3:result.index('页')]
            result_dic = {}
            for er_page in range(int(page_max)):
                try:
                    url = all_author[name] + "{index}.html".format(index=er_page + 1)
                    # print("doing", name, "page{page}".format(page=er_page + 1))
                    s = get_selector.get_selector(send_request.send_requests(url))
                    result_url = s.xpath('//li//div[@class="b"]//h4/a/@href')
                    result_title = [None] * len(result_url)
                    for i in range(len(result_url)):
                        try:
                            s = get_selector.get_selector(send_request.send_requests(base_url + result_url[i].strip('.')))
                            # print("正在打开 {url_} 获取title".format(url_=base_url + result_url[i].strip('.')))
                            result_title[i] = s.xpath('//div[@class="a"]/h1/text()')[0]
                            if "�" in result_title[i]:
                                result_title[i] = result_title.replace("�", "頫")
                            if "\\" in result_title[i]:
                                result_title[i] = result_title[i].replace("\\", "")
                            result_dic[result_title[i]] = base_url + result_url[i].strip('.')
                        except:
                            pass
                    print("done", name, "page{page}".format(page=er_page + 1))
                except Exception as e:
                    print("error:获取这一篇文章出错", url, e)
            # print(result_dic)
            all_author_dic[name] = result_dic
        except Exception as e:
            print("error:获取这一页出错了", e)
    return all_author_dic

def get_img_info(dic):
    """
    获取图片并下载
    :return:
    """
    for name in dic:
        path = create_dir(r"/root/bao", name)#先创建任务文件夹
        print("***正在弄***", name)
        for title in dic[name]:
            try:
                all_imgs = []
                # print("正在下载", title, dic[name][title])
                file_path = create_dir(path, title)  # 再创建文章文件夹
                s = get_selector.get_selector(send_request.send_requests(dic[name][title]))
                result_page = s.xpath('//td//a[@rel="nofollow"]/text()')
                img_list = s.xpath('//div[@id="newsContent"]//img/@src')
                if img_list is not []:
                    for i in range(len(img_list)):
                        if img_list[i][0] is '.':
                            img_list[i] = base_url + img_list[i].lstrip('.')
                all_imgs.extend(img_list)
                if result_page is not []:
                    max_page = int(result_page[-2].strip('.'))
                else:
                    max_page = 1
                if max_page > 1:
                    for er_page in range(max_page)[1:]:
                        url = dic[name][title].rstrip('.html')
                        url = url + "_{page}.html".format(page=er_page + 1)
                        s = get_selector.get_selector(send_request.send_requests(url))
                        # print("获取图片链接", url)
                        img_list = s.xpath('//div[@id="newsContent"]//img/@src')
                        if img_list is not []:
                            for j in range(len(img_list)):
                                if img_list[j][0] is '.':
                                    img_list[j] = base_url + img_list[j].lstrip('.')
                        all_imgs.extend(img_list)
                count = 1
                for img in all_imgs:
                    filename = file_path + "\\{i}.jpg".format(i=count)
                    # print("downloading", filename)
                    down_load(img, filename)
                    count = count + 1
            except Exception as e:
                print("下载图片错了", e)

def create_dir(path, name):
    try:
        fi_path = path + '\\' + name
        os.mkdir(fi_path)
    except Exception as e:
        print("创建文件夹错误", e)
    return fi_path

def  down_load(url, filename):
    """

    :param filename: 文件夹路径
    :return:
    """
    try:
        content = send_request.download_img(url)
        with open(filename, 'wb') as file:
            file.write(content)
    except Exception as e:
        print("写入错误", e)



get_img_info(get_urls(test_dic))