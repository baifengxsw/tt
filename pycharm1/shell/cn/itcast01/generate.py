#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng

################################################################################
##############################预计产生10T 数据##################################
################################################################################

'''

模拟6000个用户的上网记录 预计产生10T的数据

usrid （string 用户id），date(string 时间） ，ip （string ，用户上网ip），platform（string，用户使用平台），phone（string,用户的手机类型），shenfen（string，用户省份）,record(string,用户上网记录）
使用方法 先 预测要产生多大的数据 ，每条数据大概 80B  10T 数据   10*1024*1024*1024*1024*1024/80   140,737,488,355,328 条数据
设置并发度 ，设置总记录数
'''


import os
import time
import random
import  math
from multiprocessing import  Pool
ISOTIMEFORMAT='%Y-%m-%d %H:%M'


#总记录数
totalnum= 1000000
#并行数
parallizenum= 5

perthreadnum = totalnum / parallizenum
currrent_directory = os.path.dirname(os.path.realpath(__file__))
filename = "bigdata.txt"
full_path=os.path.join(currrent_directory,filename)

result_pay_time= ["2018-02-25","2018-04-21","2018-08-02","2019-04-24","2019-05-12","2019-06-18","2019-07-08",
                  "2019-07-14","2019-07-23","2019-07-27","2019-08-02","2019-08-06","2019-08-10","2019-08-12"]

def get_pay_status():
    arr = [1,2,3]
    return arr[random.randint(0,len(arr)-1)]

def get_order_total_amount():
    return random.randint(0,10000);
def getuser_id():
    a = random.randint(0, 6000)
    id = str(a).zfill(6)
    return id

def getorder_id(i):

    id = str(i).zfill(6)
    return id


def getRecord(i):
    line = getorder_id(i)+"\t"+getuser_id()+"\t"+result_pay_time[random.randint(0,len(result_pay_time)-1)]+"\t"+get_pay_status()+"\t"+get_order_total_amount()+"\n"
    return line



def setNum(i):
    return i



#写入数据
def writedata(f ,data):
    f.writelines(str(data))




def  generatedata( num ):
    f = open(full_path, 'a+')

    for i in  range(perthreadnum):

        writedata(f,getRecord(i))



if __name__ == '__main__':
    start = time.time()
    pool = Pool(parallizenum)
    for i in range(parallizenum):
        pool.apply_async(generatedata,(i,))
    pool.close()
    pool.join()
    print("over")
    end = time.time()
    print(end - start)





 