#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import  ftplib
import os

HOST = "ftp.acc.umu.se"
DIR = "cdimage"
FILE = "HEADER.html"
# 1 客户端连接远程ftp服务器
try:
    f = ftplib.FTP()
    f.set_debuglevel(2)
    f.connect(HOST)
except Exception as e:
    print(e)
    exit()
print("**** Connected to host {0}".format(HOST))

#2 客户单登录远程ftp服务器
try:
    f.login()
except Exception as e:
    print(e)
    exit()
print("*** logged in as 'anonymous")

#3 客户端进行文件和信息查询工作
try:
    f.cwd(DIR)
except Exception as e:
    print(e)
    exit()
print("**** Change dir to {0}".format(DIR))

#4 客户端进行文件下载
try:
    # 从FTP服务器上下载文件
    # 第一个参数是ftp命令
    #第二个参数是回调函数
    # 执行retr命令，下载文件到本地
    f.retrbinary("RETR {0}".format(FILE),open(FILE,"wb").write)
except Exception as e:
    print(e)
    exit()
print("下载成功")
f.quit()

 