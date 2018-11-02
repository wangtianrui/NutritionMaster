from functions import send_request, get_selector
import os

base_url = "http://www.shufabeitie.com"
person_name_list = ["东晋王羲之", "元代赵孟頫", "明代文徵明", "唐代颜真卿"]
test_name_list = ["唐代孙过庭"]

def get_urls(name_list):
    all_tie = {}
    for name in name_list:
        try:
            url = "/".join((base_url, "shufa", name))
            print("正在处理", name, url)
            s = get_selector.get_selector(send_request.send_requests(url))
            result = s.xpath('//div[@class="col-md-4 col-sm-6"]//a/@href')
            for i in result:
                all_tie[i.split('/')[-2]] = base_url + i
            print(all_tie)
        except Exception as e:
            print("字帖获取失败了", e)
    return all_tie

def get_info(dic):
    for name in dic:
        try:
            s = get_selector.get_selector(send_request.send_requests(dic[name]))
            img1 = base_url + s.xpath('//div[@id="a0"]/img/@src')[0]
            img_urls = s.xpath('//div[@id="a0"]/following-sibling::*/@data-original')
            for i in range(len(img_urls)):
                img_urls[i] = base_url + img_urls[i]
            img_urls.append(img1)
            dic[name] = img_urls
            print("get info done", name)
        except Exception as e:
            print("图片链接获取失败", e)
    return dic


def write_in(dic):
    for name in dic:
        try:
            path = create_dir(name)
            print("创建文件夹", name)
            for url in dic[name]:
                filename = path + '//' + url.split('/')[-1]
                with open(filename, 'wb') as file:
                    file.write(send_request.download_img(url))
                    print("write", url)
        except Exception as e:
            print("写入失败", e)

def create_dir(name):
    try:
        dir_path = r"E:\datapy\bb" + "\\" + name
        os.mkdir(dir_path)
    except Exception as e:
        print("文件夹创建失败", e)
    return dir_path

dic = get_info(get_urls(person_name_list))
write_in(dic)