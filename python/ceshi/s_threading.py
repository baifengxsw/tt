#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import threading
from time import sleep,ctime

class ThreadFunc:
    def __init__(self,name):
        self.name = name

    def loop(self,nloop,nsec):
        '''

        :param nloop: loop函数的名字
        :param nsec:系统的休眠时间
        :return:
        '''
        print('Start loop',nloop,'at',ctime())
        sleep(nsec)
        print('Done loop',nloop,'at',ctime())

def main():
    print("Starting at:",ctime())
    t = ThreadFunc("loop")
    t1 = threading.Thread(target=t.loop,args=("LOOP1",4))
    #下面这种写法偏西方
    t2 = threading.Thread(target=ThreadFunc("loop").loop,args=("LOOP2",2))
    t1.start()
    t2.start()
    t1.join()
    t2.join()
    print("ALL done at:",ctime())
if __name__=="__main__":
    main()
