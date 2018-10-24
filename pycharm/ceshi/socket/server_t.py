#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import socket
# Tcp Server
def serverFun():
    sock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    saddr = ("127.0.0.1",8888)
    sock.bind(saddr)
    sock.listen()
    while True:
        csock,caddr = sock.accept()
        cmsg = csock.recv(200)
        print("received msg:{0} from {1}".format(cmsg.decode(),caddr))
        rcmsg = "服务器已经接受到消息"
        csock.send(rcmsg.encode())
        csock.close()

if __name__ == "__main__":
    print("server is starting")
    serverFun()
    print("server stop")

 