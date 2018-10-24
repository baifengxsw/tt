#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import  smtplib
from email.mime.text import  MIMEText
from email.header import Header
#发送文本
msg = MIMEText("Hello,I am xiashuang","plain","utf-8")
from_addr = "1072396463@qq.com"
from_pwd = "ledgijjyrwgibcbg"
to_addr = "xiaswuxxxx@163.com"

header_from = Header("从图灵学院邮箱发出去的<1072396463@qq.com>", "utf-8")
msg["From"] = header_from

# 填写接受者信息
header_to = Header("sdfs<xiaswuxxxx@163.com>", "utf-8")
msg['To'] = "ssff<xiaswuxxxx@163.com>"

header_sub = Header("这是图灵学院的主题", 'utf-8')
msg['Subject'] = header_sub

#输入邮件服务器的地址
smtp_srv = "smtp.qq.com"
try:
    srv = smtplib.SMTP_SSL(smtp_srv.encode(),465)
    srv.login(from_addr,from_pwd)
    srv.sendmail(from_addr,[to_addr],msg.as_string())
    srv.quit()
except Exception as e:
    print(e)
