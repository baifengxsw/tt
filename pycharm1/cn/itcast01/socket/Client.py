#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import  socket
sock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
sock.connect(("localhost",8888))

sock.send("hello world".encode())
sock.close()
