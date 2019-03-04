from functions import get_selector, send_request
import csv
import requests
import os
import time

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36'
}

def get_img_url(name):
    base_url = "http://so.meishi.cc/index.php?q="
    try:
        time.sleep(2)
        s = get_selector.get_selector(send_request.send_requests(base_url + name))
        img = s.xpath('//div[@class="search2015_cpitem"][1]//a[@class="img"]//img/@src')
        print(name, img)
        return img[0]
    except Exception as e:
        print(e)

def get_old_info(filename):
    """

    :param filename: 重新修改的文件名
    :return:返回旧的字典列表
    """
    old_dicts = []
    try:
        with open(r'E:\datapy\天天美食\脏腑调理\%s' % filename, 'r') as file:
            reader = csv.DictReader(file)
            for i in reader:
                old_dicts.append(i)
        return old_dicts
    except Exception as e:
        print(e)

def alter_info(name, dic):
    dic["图片url"] = get_img_url(name)
    return dic

def rewrite_info(filename, old_dicts):
    """

    :param filename: 重写文件名
    :param old_dicts: 重新写入的字典列表
    :return:
    """
    index = 1
    try:
        with open(r'E:\datapy\test\脏腑调理\%s' % filename, 'w', newline='') as file:
            fieldnames = ["菜名", "分类", "口味", "食材", "主要工艺", "制作时间", "做法", "图片url"]
            writer = csv.DictWriter(file, fieldnames)
            writer.writeheader()
            for i in old_dicts:
                try:
                    writer.writerow(i)
                    index = index + 1
                    print("done", index)
                except Exception as e:
                    print("写入错误", e)
    except Exception as e:
        print("读取文件出错", e)

def get_filenames(path):
    """

    :param path: 文件路径
    :return: 所有文件名
    """
    filenames = []
    for root, dirnames, s in os.walk(path):
        filenames.extend(s)
    return filenames

if __name__ == "__main__":
    filenames = get_filenames(path="E:\datapy\天天美食\脏腑调理")
    for filename in filenames:
        old_dicts = get_old_info(filename)
        new_dicts = []
        for old_dict in old_dicts:
            time.sleep(2)
            old_dict["图片url"] = get_img_url(old_dict.get("菜名"))
            new_dicts.append(old_dict)
            print("write new done")
        rewrite_info(filename, new_dicts)

