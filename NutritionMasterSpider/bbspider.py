from selenium import webdriver
from functions import send_request, get_selector
import time
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import os

base_url = "http://www.shufabeitie.com"
person_name_list = ["东晋王羲之", "元代赵孟頫", "明代文徵明", "唐代颜真卿"]
test_name_list = ["东晋王羲之"]

def get_urls(list):
    """
    获取该网站所有的贴
    :param list: person_name_list
    :return:
    """
    urls = []
    for name in list:
        try:
            time.sleep(5)
            url = base_url + "/shufa/" + name
            print(name, "start")
            s = get_selector.get_selector(send_request.send_requests(url))
            result = s.xpath('//div[@class="caption ellipsis"]//a/@href')
            for i in range(len(result)):
                result[i] = base_url + result[i]
            print(name, "done")
            urls.extend(result)
        except Exception as e:
            print(e)
    print(urls)
    return urls

def get_img_element_id(url):
    try:
        s = get_selector.get_selector(send_request.send_requests(url))
        id_list = s.xpath('//div[@id="beitie-imgs-container"]//div/@id')
        return id_list
    except Exception as e:
        print(e)

def get_info(urls):
    """
    从所有的贴中取出图片
    :param urls: 所有的地址
    :return:
    """
    browser = webdriver.Chrome()
    wait = WebDriverWait(browser, 10)
    all_list_dic = {}

    for url in urls[:1]:
        time.sleep(2)
        browser.get(url)
        print("正在处理", url)
        btn = wait.until(EC.element_to_be_clickable((By.ID, "beitie-pagination-next")))
        #btn = browser.find_element_by_id("")
        id_list = get_img_element_id(url)
        img_list = []
        for img_id in id_list:
            try:
                time.sleep(3)
                # img_elment = browser.find_element_by_xpath('//div[@id="{id}"]/img'.format(id=img_id))#取属性
                img_element = wait.until(
                    EC.visibility_of_element_located((By.XPATH, '//div[@id="{id}"]/img'.format(id=img_id))))
                img = img_element.get_attribute('src')
                print(img)
                img_list.append(img)
                time.sleep(3)
                btn.click()
            except Exception as e:
                print("下载图片出错", e)
        write_in(img_list)

def create_dir(name):
    dir_path = r"E:\datapy\bb\东晋王羲之" + "\\" + name
    os.mkdir(dir_path)
    return dir_path


def write_in(urls):
    dir_name = urls[0].split('/')[4]
    path = create_dir(dir_name)
    for url in urls:
        create_dir(dir_name)
        file_name = path + "\\" + url.split('/')[-1] + '.jpg'
        with open(file_name, 'wb') as file:
            file.write(send_request.download_img(url))

get_info(get_urls(test_name_list))
