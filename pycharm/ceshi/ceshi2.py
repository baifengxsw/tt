#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
#coding = utf-8
# import socket
# s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
# #建立连接
# s.connect(('127.0.0.1',9999))
# print(s.recv(1024).decode('utf-8'))
# for data in [b'Michael',b'Tracy',b'Sarah']:
#     s.send(data)
#     print(s.recv(1024).decode('utf-8'))
# s.send(b'exit')
# s.close()
# dd = dict(xia=1, wu =3,shuang=2)
# print(dd)
# s = sorted(dd.items(),key=lambda item:item[1],reverse=False)
# print(s)


# def count():
#     def f(j):
#         def g():
#             return j*j
#         return g
#     ret = []
#     for x in range(1,4):
#         ret.append(f(x))
#     return ret
# s = count()
# print(s[0]())
# print(s[1]())
# print('*'*50)
# import  time
# def printime(f):
#     def wrapper(*args,**kwargs):
#         print("Time:",time.ctime())
#         return f(*args,**kwargs)
#     return wrapper
#
# @printime
# def hello():
#     print("hello world")
#
