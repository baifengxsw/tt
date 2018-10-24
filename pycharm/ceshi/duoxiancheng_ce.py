#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng

import threading
sum = 0
loopSum = 10000000


def myAdd():
    global sum, loopSum

for i in range(1, loopSum):
    sum += 1

def myMin():
    global sum, loopSum
for i in range(1, loopSum):
    sum -= 1
if __name__ == "__main__":
    print("startig counting....{0}".format(sum))
t1 = threading.Thread(target=myAdd, args=())
t2 = threading.Thread(target=myMin, args=())
t1.start()
t2.start()

t1.join()
t2.join()
print("Done counting.....{0}".format(sum))
