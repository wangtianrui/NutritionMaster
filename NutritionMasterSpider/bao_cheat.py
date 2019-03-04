import requests
import json
from lxml import etree
# from functions import send_request, get_selector

header = {
    'authority': 'www.zhenhaotv.com',
    'method': 'POST',
    'path': '/',
    'scheme': 'https',
    'accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8',
    'accept-encoding': 'gzip, deflate, br',
    'accept-language': 'zh-CN,zh;q=0.9',
    'cache-control': 'max-age=0',
    'content-length': '86',
    'content-type': 'application/x-www-form-urlencoded',
    'cookie': 'Hm_lvt_1ebdb876cf5aaff194ebd474e2ae2c52=1538639708; SERVERID=4d5d41d7b10da55b4b26f74f163ced97|1538640214|1538639706; Hm_lpvt_1ebdb876cf5aaff194ebd474e2ae2c52=1538640215',
    'origin': 'https://www.zhenhaotv.com',
    'referer': 'https://www.zhenhaotv.com/',
    'upgrade-insecure-requests': '1',
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36',
}

data = {
    'text': '小老弟',
    'font': '9',
    'size': '68',
    'color': '#000000',
    'bg': '#ffffff',
    'list': 'open'
}

url = "https://www.zhenhaotv.com"

status_code = 0
# s = get_selector.get_selector(send_request.post_request())
s = etree.HTML(requests.post(url=url, data=data, headers=header).text)
final_url = s.xpath('//div[@class="panel panel-default"]//img/@src')[0]
final_url = url + final_url.strip('.')

r = requests.get(final_url)
status_code = r.status_code
print(status_code, final_url)
# while status_code != 200:
