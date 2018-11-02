from lxml import etree

def get_selector(html):
    try:
        s = etree.HTML(html)
        return s
    except Exception as e:
        print("选择器获取失败    ", e)
        return None
