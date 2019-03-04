from functions import get_selector, send_request

base_url = "https://www.xinshipu.com/%E9%A5%AE%E9%A3%9F%E5%81%A5%E5%BA%B7.html"

def get_info():
    s = get_selector.get_selector(send_request.send_requests(base_url))
    name = s.xpath('//li//a[@rel="cpdq"]/text()')
    return name

with open( r"E:\datapy\类型名称.txt", 'w', encoding='utf-8') as file :
    for i in get_info():
        file.write(i)
        file.write('\n')
