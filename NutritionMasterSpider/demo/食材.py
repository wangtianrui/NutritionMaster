# 8 9 10 14 15 25
from functions import get_selector, send_request
import time
import csv

aim_url = "http://www.chinacaipu.com/shicai/"

def get_urls():
    """

    :return:
    """
    urls = []
    s = get_selector.get_selector(send_request.send_requests(aim_url))
    m = [8, 9, 10, 14, 15, 25]
    for i in m:
        url = s.xpath('//div[@class="fd_cont"]//dl[%d]//a/@href' % i)
        urls = urls + url
    return urls

def get_info(url):
    """

    :param url:
    :return: 返回的a是营养价值，b是食用效果
    """
    dic = {
        "食材": "",
        "简介": "",
        "营养价值": "",
        "食用效果": ""
    }
    try:
        s = get_selector.get_selector(send_request.send_requests(url))
        # 储存功效信息
        fun = s.xpath('//div[@class="fd_yygx"]//strong[1]/following-sibling::*')
        final_fun = []
        intro = s.xpath('//div[@class="n_sp_main_info"]//p/text()')
        dic["食材"] = s.xpath('//div[@class="fd_tit2"]//strong/text()')
        t = []
        jianjie = s.xpath('//div[@class="n_sp_main_info"]//p/text()')
        for i in jianjie:
            t.append(i.strip())
        dic["简介"] = t
        for i in range(len(fun)):
            info = s.xpath('//div[@class="fd_yygx"]//strong[1]/following-sibling::*[%d]/text()' % (i + 1))
            if info is not None:
                final_fun = final_fun + info
            for m in range(len(final_fun)):
                final_fun[m] = final_fun[m].strip()
        for i in range(len(intro)):
            intro[i] = intro[i].strip()
        final_fun.remove('')
        for i in range(len(final_fun)):
            if "的挑选" in final_fun[i]:
                final_fun = final_fun[0:i]
                break
        for i in range(len(final_fun)):
            if "的存储方法" in final_fun[i]:
                final_fun = final_fun[0:i]
                break
        a = []
        b = []
        for i in range(len(final_fun)):
            if "的食用效果" in final_fun[i]:
                a = final_fun[1:i]
                b = final_fun[i + 1:]
        if len(a) is 0:
            print(final_fun[0])
            if "的营养价值" in final_fun[0]:
                print("doit")
                a = final_fun[1:]
        print(a)
        print(b)
        dic["营养价值"] = a
        dic["食用效果"] = b
        return dic
    except Exception as e:
        print(e)

def write_files(dics):
    with open(r'E:\datapy\直接食用.csv', 'w', newline="") as file:
        index = 1
        fieldnames = ["食材", "简介", "营养价值", "食用效果"]
        writer = csv.DictWriter(file, fieldnames=fieldnames)
        writer.writeheader()
        for dic in dics:
            try:
                writer.writerow(dic)
                index = index + 1
                print("write", index)
            except Exception as e:
                print(e)

dic_list = []
for i in get_urls():
    time.sleep(2)
    print("正在", i)
    dic_list.append(get_info(i))
    print("done")
write_files(dic_list)

