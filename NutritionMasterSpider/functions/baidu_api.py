from aip import AipImageClassify
import requests

wang_key = {
    "id": "11790313",
    "key": "dqAy7sFcjgZ7TdE8R7W8cEPZ",
    "skey": "m6W8xr2GXAijfuUU03t2QNch479oHoLu"
}

zhao_key = {
    "id": "11790318",
    "key": "vpuuSkeUjBdKs9cvAXDT5qkn",
    "skey": "xh0DP0Loulp273mBjTNltCTGhoB2mXh9"
}

my_key = {
    "id": "11786059",
    "key": "vvIDyGshEY1dqa2AqVE2poix",
    "skey": "XReL682wuguUkMg8kCL4IvPzAxlrPX0H"
}

yang_key = {
    "id": "11810381",
    "key": "YlXzoj4X3mnC6lFVPF7akSKu",
    "skey": "45HM07xWIGUZeW7nDcyZAHVYQzjL99bs"
}

he_key = {
    "id": "14249521",
    "key": "65nKFiLwwbL5cqvK4fkIyNSn",
    "skey": "GVWdoLENUphPtRDvhLvK5ZuQUZ6WVPf2"
}

bao_key = {
    "id": "14249615",
    "key": "Rrcns3DH4ItNjO8AxgURLcpT",
    "skey": "Sw2FBXU61ED8u15HWZxRONedu4weLmjF"
}

fei_key = {
    "id": "14249624",
    "key": "zg9kcIfHtSjLi6SRtXzP50ow",
    "skey": "xC7erkP6VaLMP2C4zE445FPdp9OG62rG"
}

friend1_key = {
    "id": "14249589",
    "key": "LMpD3rq7bSjafY7HN4BpXV9w",
    "skey": "NUwlak8E9LhzFlRLGEzB5Z8hKVHap6Qz"
}

def get_Ai(key):
    return AipImageClassify(key.get("id"), key.get("key"), key.get("skey"))

def get_client(times):
    if times <= 499:
        client = get_Ai(bao_key)
    elif times <= 999:
        client = get_Ai(friend1_key)
    else:
        return None
    return client


def get_file_content(filepath):
    with open(filepath, 'rb') as fp:
        return fp.read()

def get_calorie(img_url, times):
    try:
        r = requests.get(img_url)
        with open(r"E:\datapy\asd.jpg", 'wb') as file:
            file.write(r.content)

        image = get_file_content(r"E:\datapy\asd.jpg")
        client = get_client(times)
        a = client.dishDetect(image)
        print(a["result"][0])
        return str(a["result"][0].get("calorie"))
    except Exception as e:
        print("error", e)

