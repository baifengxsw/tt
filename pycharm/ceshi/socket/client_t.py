#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import  socket

def clientFun():
    sock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    saddr = ("127.0.0.1",8888)
    sock.connect(saddr)
    sock.send("服务器您好".encode())
    ret = sock.recv(200)
    print("received form  data is {0}".format(ret.decode()))
    sock.close()
if __name__ == "__main__":
    print("client is starting ")
    clientFun()
    print("client is stop")