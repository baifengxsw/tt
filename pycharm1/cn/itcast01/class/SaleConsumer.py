#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import threading
tickets = 100
lock = threading.Lock()
def getTicket():
   # global lock
    lock.acquire()
    global tickets
    tmp = 0
    if tickets>0:
        tmp = tickets
        tickets -= 1;

    lock.release();
    return tmp
class Saler(threading.Thread):
    def run(self):
        global tickets
        while True:
            if(tickets>0):
                tmp = getTicket()
                print(threading.current_thread().getName() + "售出了" + str(tmp))

s2= Saler()
s2.start()