#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import socket

def clientFun():
    sock = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
    smsg = "你好，服务器"
    addr= ("127.0.0.1",9899)
    sock.sendto(smsg.encode(),addr)
    data ,add = sock.recvfrom(300)
    print("从服务器端{0}发送的数据为{1}".format(add,data.decode()))

if __name__ == "__main__":
    print("client is running")
    clientFun()
    print("end")