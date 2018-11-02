import requests
from functions import get_proxy
import time

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36'
}

proxy_list = get_proxy.get_proxys(1)

def send_requests(url):
    """
    发送请求
    :param url:
    :return:
    """
    try:
        time.sleep(1)
        proxy = get_proxy.test_proxy(proxy_list)
        r = requests.get(url=url, headers=headers, timeout=10, proxies=proxy)
        if r.status_code == 200:
            r.encoding = r.apparent_encoding
            return r.text
        else:
            print(r.status_code, "   请求失败")
            return None
    except requests.RequestException as e:
        print("发送请求失败   ", e)
        return None
def requests_with_params(url, params):
    """
    发送请求
    :param url:
    :return:
    """
    try:
        time.sleep(1)
        proxy = get_proxy.test_proxy(proxy_list)
        r = requests.get(url=url, headers=headers, timeout=10, proxies=proxy, params=params)
        if r.status_code == 200:
            r.encoding = r.apparent_encoding
            return r.text
        else:
            print(r.status_code, "   请求失败")
            return None
    except requests.RequestException as e:
        print("发送请求失败   ", e)
        return None

def download_img(url):
    """
    发送请求
    :param url:
    :return:
    """
    try:
        time.sleep(1)
        proxy = get_proxy.test_proxy(proxy_list)
        r = requests.get(url=url, headers=headers, timeout=10, proxies=proxy)
        if r.status_code == 200:
            r.encoding = r.apparent_encoding
            return r.content
        else:
            print(r.status_code, "   请求失败")
            return None
    except requests.RequestException as e:
        print("发送请求失败   ", e)
        return None

def post_request(url, header, data):
    """
    发送请求
    :param url:
    :return:
    """
    try:
        time.sleep(1)
        proxy = get_proxy.test_proxy(proxy_list)
        r = requests.post(url=url, headers=header, timeout=10, proxies=proxy, data=data)
        if r.status_code == 200:
            return r.text
        else:
            print(r.status_code, "   请求失败")
            return None
    except requests.RequestException as e:
        print("发送请求失败   ", e)
        return None