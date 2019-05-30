#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import socket
#创建socket对象  sock_stream 表示tcp
sock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
#绑定地址
sock.bind(("localhost",8888))

#启动监听
sock.listen(0)
print("开始启动监听")
while True:
    #接受连接
    (clientSock,addr) = sock.accept()
    print(str(addr)+"开始连接....")
    while True:
        recv = clientSock.recv(300)

        if not recv:
            clientSock.close()
            break
        print("来自" + str(addr) + "的消息:" + str(recv.decode()))
sock.close()