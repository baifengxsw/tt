#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import  socket
import  time
def serverFun():
    sock = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
    addr =("127.0.0.1",9899)
    sock.bind(addr)
    data ,add = sock.recvfrom(300)
    print(data.decode())
    print("从{0}发送的数据为{1}".format(add,data.decode()))
    ret = "服务器已经接受到信息"
    sock.sendto(ret.encode(),add)
    sock.close()
if __name__ =="__main__":
    print("server is start running")
    while 1:
        try:
            serverFun()
        except Exception as e:
            print(e)
        time.sleep(1)
    print("server is end")