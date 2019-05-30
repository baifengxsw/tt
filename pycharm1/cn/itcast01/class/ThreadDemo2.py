#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng

import threading

class Saler(threading.Thread):
    def run(self):
        for i in (1,2,3,4,5):
            print(threading.current_thread().getName()+"---"+str(i))


for i in (1,2,3):
    s1 = Saler()
    s1.start()