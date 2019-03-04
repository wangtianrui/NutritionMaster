from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

base_url = "https://www.xinshipu.com/"

browser = webdriver.Chrome()
time.sleep(1)
browser.get(base_url)
names = []
urls = []
with open(r"E:\datapy\类型名称.txt", 'r', encoding='utf-8') as file:
    for i in file.readlines():
        s = i.strip('\n')
        names.append(s)
index = 1
for i in names:
    try:
        search_box = browser.find_element_by_id('q')
        time.sleep(2)
        search_box.clear()
        search_box.send_keys(i)
        search_box.send_keys(Keys.ENTER)
        urls.append(browser.current_url)
        print(i, "done", index, browser.current_url)
        index += 1
    except Exception as e:
        print("这一页没有内容   ", e)
with open(r"E:\datapy\网页.txt", 'w', encoding='utf-8') as file:
    for i in urls:
        file.write(i)
        file.write('\n')
