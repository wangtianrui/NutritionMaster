import requests
from lxml import etree
import time
from requests.exceptions import RequestException
import random
base_url = "https://www.kuaidaili.com/free/inha/"
headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36'
}

def get_proxys(page):
    try:
        proxy_list = []
        print("正在抓代理...")
        for i in range(page):
            time.sleep(5)
            url = base_url + str(i + 1) + "/"
            r = requests.get(url, headers=headers, timeout=10)
            if r.status_code == 200:
                s = etree.HTML(r.text)
                proxy_ip = s.xpath('//tbody//tr//td[@data-title="IP"]/text()')
                proxy_port = s.xpath('//tbody//tr//td[@data-title="PORT"]/text()')
                proxy_kind = s.xpath('//tbody//tr//td[@data-title="类型"]/text()')
                if len(proxy_ip) == len(proxy_port) == len(proxy_kind):
                    for i in range(len(proxy_ip)):
                        proxy = {
                            'HTTP': proxy_ip[i] + ":" + proxy_port[i],
                            'HTTPS': proxy_ip[i] + ":" + proxy_port[i]
                        }
                        proxy_list.append(proxy)
            else:
                print(str(r.status_code) + "---" + r.url)
        print("代理完成")
        return proxy_list
    except RequestException as e:
        print("代理error:" , e)

def test_proxy(proxy_list):
    try:
        print("正在选择代理...")
        proxy = random.choice(proxy_list)
        test_url = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=02049043_21_pg&wd=" + str(random.random())
        r = requests.get(test_url, proxies=proxy, headers=headers, timeout=10)
        if r.status_code == 200:
            print("代理选择成功")
            return proxy
        else:
            print("代理选择失败，重新选择")
            test_proxy(proxy_list)
    except:
        print("验证失败")