from functions import get_selector, send_request

import time

import csv

base_url = "http://www.boohee.com"
search_url = "http://www.boohee.com/food/search?keyword="

test_list = ['番茄炒蛋', '土豆丝']

def get_url(name):
    time.sleep(1.5)
    s = get_selector.get_selector(send_request.send_requests(search_url + name))
    url = s.xpath('//li[@class="item clearfix"][1]//h4//a/@href')[0]
    url = base_url + url
    print(url)
    return url

def get_info(url):
    dic = {}
    s = get_selector.get_selector(send_request.send_requests(url))
    name = s.xpath('//h2[@class="crumb"]/text()')[-1].strip().replace('/ ', '')
    calorie = s.xpath('//span[@id="food-calory"]//span[@class="stress red1"]/text()')[0]
    img_url = s.xpath('//div[@class="food-pic pull-left"]//a/@href')[0]
    dic["new_name"] = name
    dic["calorie"] = calorie
    dic["img_url"] = img_url
    return dic

def read_csv(path):
    """

    :param path: csv文件的路径
    :return:
    """
    old = []
    with open(path, 'r') as file:
        reader = csv.DictReader(file)
        for row in reader:
            try:
                old.append(row)
            except:
                pass
    return old#这里记得改了

def write_csv(path, new_dics):
    """

    :param path: 写入文件的路径
    :return:
    """
    with open(path, 'w', newline='') as file:
        fieldnames = ['', 'name', 'new_name', 'calorie', 'img_url']
        writer = csv.DictWriter(file, fieldnames)
        writer.writeheader()
        for new_dic in new_dics:
            try:
                writer.writerow(new_dic)
            except:
                pass

if __name__ == '__main__':
    rows = read_csv(r"F:\Tencent\TIM\Tencent Files\739843128\FileRecv\menu_names.csv")
    for row in rows:
        try:
            dic = get_info(get_url(row.get('name')))
            row.update(dic)
        except Exception as e:
            print(e)
    write_csv(r"E:\datapy\new_info.csv", rows)

