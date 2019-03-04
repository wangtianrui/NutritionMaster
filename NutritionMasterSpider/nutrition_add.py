from functions import send_request, get_selector
import csv


base_url = "http://www.boohee.com"
search_url = "http://www.boohee.com/food/search?keyword="

test_list = ["碘盐", ]

def get_url(name):
    s = get_selector.get_selector(send_request.send_requests(search_url + name))
    url = s.xpath('//li[@class="item clearfix"][1]//h4//a/@href')[0]
    url = base_url + url
    print(url)
    return url

def get_info(url):
    s = get_selector.get_selector(send_request.send_requests(url))
    info = s.xpath('//div[@class="content"]//dd[2]/following::dd//span/text()')
    info_dic = {}
    for i in range(int(len(info) / 2)):
        try:
            info_dic[info[i * 2]] = info[(i + 1) * 2 - 1]
        except:
            pass
    for ingredient in info_dic:
        try:
            float(info_dic[ingredient])
        except:
            info_dic[ingredient] = '-1'
    return info_dic

def read_csv(path):
    """

    :param path: csv文件的路径
    :return:
    """
    old = []
    with open(path, 'r') as file:
        reader = csv.DictReader(file)
        for i in reader:
            try:
                old.append(i)
            except:
                pass
    return old#这里记得改了

def write_csv(path, old_dic):
    """

    :param path: 写入文件的路径
    :return:
    """
    with open(path, 'w', newline='') as file:
        fieldnames = ['', 'material_name', 'name_correct', '镁(毫克)', '维生素A(微克)', '铁(毫克)', '硒(微克)', '钾(毫克)', '铜(毫克)', '磷(毫克)', '胡萝卜素(微克)', '碳水化合物(克)', '锰(毫克)', '钠(毫克)', '胆固醇(毫克)', '烟酸(毫克)', '热量(大卡)', '核黄素(毫克)', '锌(毫克)', '维生素C(毫克)', '硫胺素(毫克)', '脂肪(克)', '钙(毫克)', '维生素E(毫克)', '纤维素(克)', '蛋白质(克)']
        writer = csv.DictWriter(file, fieldnames)
        writer.writeheader()
        for i in old_dic:
            try:
                writer.writerow(i)
            except:
                pass

m = read_csv(r"F:\Tencent\TIM\Tencent Files\739843128\FileRecv\material_names.csv")
for row in m:
    try:
        row.update(get_info(get_url(row.get('name_correct'))))
        # for name in row:
        #     if row.get(name) is None:
        #         row[name] = "-1"
        print(row)
    except Exception as e:
        print(e)
write_csv(r"E:\datapy\test.csv", m)
