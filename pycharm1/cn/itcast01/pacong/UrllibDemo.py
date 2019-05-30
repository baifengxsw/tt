#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng


import urllib
import urllib.request
import urllib.response
import  re # 正则表达式模块
import  os
r = urllib.request.urlopen("http://www.baidu.com")
#读取资源文件内容 ，作为bytes读取
myBytes = r.read()
#解码bytes成为string
mystr = myBytes.decode("utf-8")
r.close()
#定义下载网页的方法
regex = u'<a\s*href="([\u0000-\uffff&&^"]*?)"'
def download(url):
    path = url
    fileDir = "e:/out/"
    fileName = path.replace(":","_").replace("/","$").replace("?","$")
    path = fileDir + fileName

    request = urllib.request.urlopen(url)
    page = request.read()
    request.close()


    if not os.path.exists(path):
        #保存文件到磁盘
        f = open(path,"wb+")
        f.write(page)
        f.close()
        try:
            res = re.finditer(regex, str(page))
            for r in res:
                print(r.group(1))
                urlget = r.group(1)
                if urlget.startswith("http://"):
                    download(urlget)
                elif urlget.startswith("//"):
                    download(urlget.replace("//","http://"))
        except Exception:
            print(url + ":"+"提取失败")
            return

        #下载并且写入文件
download("https://www.jd.com")




 