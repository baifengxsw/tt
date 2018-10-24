#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
from contextlib import contextmanager

# class Query(object):
#
#     def __init__(self, name):
#         self.name = name
#
#     def query(self):
#         print('Query info about %s...' % self.name)
#
# @contextmanager
# def create_query(name):
#     print('Begin')
#     q = Query(name)
#     yield q
#     print('End')
# with create_query('Bob') as q:
#     q.query()
# @contextmanager
# def tag(name):
#     print('<%s>'%name)
#     yield
#     print('<%s>'%name)
#
# with tag('h1'):
#     print('hello')
#     print('world')
# from contextlib import closing
# from urllib.request import  urlopen
# with closing(urlopen('https://www.baidu.com'))as page:
#     for line in page:
#         print(line)
# from urllib import request
# req = request.Request('http://www.baidu.com/')
# req.add_header('User-Agent', 'Mozilla/6.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/8.0 Mobile/10A5376e Safari/8536.25')
# with request.urlopen(req)as f:
#     data = f.read()
#     print('Status',f.status,f.reason)
#     for k,v in f.getheaders():
#         print('%s,%s'%(k,v))
#coding=utf-8
import socket
import threading
import time
s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.bind(('127.0.0.1',9999))
s.listen(5)
print('Waiting for connection....')
def tcplink(sock ,addr):
    print('Accept new connection from %s:%s....'%addr)
    sock.send(b'Welcome!')
    while True:
        data = sock.recv(1024)
        time.sleep(1)
        if not data or data.decode('utf-8')=='exit':
            break
        sock.send(('Hello,%s!'%data.decode('utf-8')).encode('utf-8'))
    sock.close()
    print('Connection from %s:%s closed.' % addr)
while True:
    sock,addr = s.accept()
    t = threading.Thread(target=tcplink,args=(sock,addr))
    t.start()


