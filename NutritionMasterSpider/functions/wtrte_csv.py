import csv

def write_csv(menu_list, path):
    try:
        with open(path, "w", newline="") as csvfile:
            index = 1
            fieldnames = ["菜名", "分类", "口味", "食材", "主要工艺", "制作时间", "做法", "图片url"]
            writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
            writer.writeheader()
            for menu in menu_list:
                try:
                    writer.writerow(menu)
                    print("write" + str(index))
                    index = index + 1
                except Exception as e:
                    print("文件操作异常，写入失败", e)
    except Exception as e:
        print("文件操作异常，打开失败", e)

