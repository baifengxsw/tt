#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEBase,MIMEMultipart
from email.header import Header
# 添加文件头信息
mail_mul = MIMEMultipart()  #如果要同时支持html和text 则在添加"alternative"
#构建邮件正文
mail_text = MIMEText("Hello I am sender by python","plain","utf-8")
#添加文件头信息
header_from = Header("从夏双武qq邮箱发出","utf-8")
mail_text["from"] = header_from
header_to = Header("to 网易邮箱","utf-8")
mail_text["to"] = header_to
header_sub = Header("搬砖","utf-8")
mail_text["subject"]  = header_sub
mail_mul.attach(mail_text)
#构建附件 需要从本地进行读取 以rb方式打开
with open("02.html","rb")as f:
    s = f.read()
    m = MIMEText(s,"base64","utf-8")
    m["Content-Type"] = "application/octet-stream"
    #注意 attachment 后分好为英文状 filename 后面需要引号包裹
    m["Content-Disposition"] = "attachment; filename='02.html'"
    mail_mul.attach(m)
from_addr = "1072396463@qq.com"
from_pwd = "ledgijjyrwgibcbg"
to_addr = "xiaswuxxxx@163.com"
#输入邮件服务器的地址
smtp_srv = "smtp.qq.com"
try:
    srv = smtplib.SMTP_SSL(smtp_srv.encode(),465)
    srv.login(from_addr,from_pwd)
    srv.sendmail(from_addr,[to_addr],mail_mul.as_string())
    srv.quit()
except Exception as e:
    print(e)
