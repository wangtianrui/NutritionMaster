import os
import csv
from functions import baidu_api

times = 1

def get_filenames(path):
    """

    :param path: 文件路径
    :return: 所有文件名
    """
    filenames = []
    for root, dirnames, s in os.walk(path):
        filenames.extend(s)
    return filenames

def get_old_info(filename):
    """

    :param filename: 重新修改的文件名
    :return:返回旧的字典列表
    """
    old_dicts = []
    try:
        with open(r'E:\datapy\test\脏腑调理\%s' % filename, 'r') as file:
            reader = csv.DictReader(file)
            for i in reader:
                old_dicts.append(i)
        return old_dicts
    except Exception as e:
        print(e)

def write_in_calorie(old_dicts):
    global times
    for i in old_dicts:
        print(i.get('图片url'), times)
        i["卡路里"] = baidu_api.get_calorie(i.get('图片url'), times)
        times = times + 1
    return old_dicts

def rewrite_info(filename, old_dicts):
    """

    :param filename: 重写文件名
    :param old_dicts: 重新写入的字典列表
    :return:
    """
    index = 1
    try:
        with open(r'E:\datapy\final\脏腑调理\%s' % filename, 'w', newline="") as file:
            fieldnames = ["菜名", "分类", "口味", "食材", "主要工艺", "制作时间", "做法", "图片url", "卡路里"]
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

if __name__ == "__main__":
    filenames = get_filenames(r'E:\datapy\test\脏腑调理')
    for filename in filenames:
        dics = get_old_info(filename)
        dics = write_in_calorie(dics)
        rewrite_info(filename, dics)
        print(filename, "done")


