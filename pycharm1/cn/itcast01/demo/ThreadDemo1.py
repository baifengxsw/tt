#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng

#定义函数

import _thread
import threading
import time
def hello():
    start = int(time.time()*1000)
    print(threading.current_thread().getName())

    print("hello world")
    print(time.time()*1000-start)
hello()

_thread.start_new_thread(hello,())
time.sleep(3)