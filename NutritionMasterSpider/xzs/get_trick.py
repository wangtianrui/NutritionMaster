from functions import send_request, get_selector
import csv

base_url = "http://www.39yst.com"
list_url = "http://www.39yst.com/changshi/list_24_"

def get_url(page_url):
    """
    该方法返回当前界面的所有url
    :param page_url: 某一页的网址
    :return:
    """
    try:
        s = get_selector.get_selector(send_request.send_requests(page_url))
        urls = s.xpath('//div[@class="item_all"]//p[@class="item_tit"]//a/@href')
        return urls
    except Exception as e:
        print(e)
        return []

def get_info(url):
    """
    获取段落文字信息
    (这里有个单词记错了，comment应该是content，不过问题应该不大)
    :param url: 详情界面url
    :return:
    """
    try:
        s = get_selector.get_selector(send_request.send_requests(url))
        comment = s.xpath('//div[@id="articleContent"]/p/following-sibling::*/text()')
        title = s.xpath('//h1/text()')[0]
        for s in range(len(comment)):
            comment[s] = comment[s].strip()
            comment[s] = comment[s].lstrip('。')
            comment[s] = comment[s].lstrip('(')
            comment[s] = comment[s].lstrip('?')
            comment[s] = comment[s].lstrip(')')
            comment[s] = comment[s].lstrip('!')
            comment[s] = comment[s].lstrip('：')
            comment[s] = comment[s].lstrip('、')
            comment[s] = comment[s].lstrip(',')
            comment[s] = comment[s].lstrip('》')
            comment[s] = comment[s].lstrip('《')
            comment[s] = comment[s].lstrip(':')
        for i in comment:
            if i is '':
                comment.remove(i)
            if len(i) is 1:
                comment.remove(i)
        try:
            index = comment.index("本篇文章版权归民福康健康所有，未经许可，谢绝转载。")
            s = "\n".join(comment[:index])
        except:
            s = "\n".join(comment)
        print("正在获取", comment[0][:5], "...")
        dic = {}
        dic['title'] = title
        dic['content'] = s
        return dic
    except Exception as e:
        print(e)
        return ''

def write_csv(path, dics):
    """
    把内容写入
    :param path:储存位置
    :param dics:信息字典列表
    :return:
    """
    with open(path, 'w', newline='') as file:
        fieldnames = ['title', "content"]
        writer = csv.DictWriter(file, fieldnames)
        writer.writeheader()
        for dic in dics:
            try:
                writer.writerow(dic)
            except:
                pass

if __name__ == "__main__":
    info_list = []
    for i in range(20):
        try:
            page_url = list_url + "{page}.shtml".format(page=i + 1)
            info_urls = get_url(page_url)
            for info_url in info_urls:
                info_list.append(get_info(info_url))
        except:
            pass
    write_csv(path=r"E:\datapy\trick.csv", dics=info_list)


