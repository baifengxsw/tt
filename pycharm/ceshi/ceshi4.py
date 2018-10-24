#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import time
import threading
def loop():
    print('start loop 0 at:',time.time())
    time.sleep(4)
    print('end loop 0 at:',time.time())

def loop1():
    print('start loop 1 at:',time.time())
    time.sleep(5)
    print('end loop 1 at :',time.ctime())
def loop2():
    print('start loop 2 at:',time.time())
    time.sleep(2)
    print('end loop 2 at:',time.time())

def main():

    print('Starting at:',time.time())
    t1 = threading.Thread(target=loop,name="Thread0",args=([]))
    t2 = threading.Thread(target=loop2,name="Thread2",args=([]))
    t3 = threading.Thread(target=loop1,name="Thread1",args=())
    t1.start()
    t2.start()
    t3.start()
    time.sleep(3)
    for thr in threading.enumerate():
        print("this running thread is {0}".format(thr.getName()))
    print("the running num is {0}".format(threading.activeCount()))


    t1.join()
    t2.join()
    t3.join()
    print('ending at:',time.time())

if __name__ == '__main__':
    main()

 