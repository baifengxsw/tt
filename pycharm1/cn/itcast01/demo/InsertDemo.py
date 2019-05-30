#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import  pymysql
#打开数据库连接
try:
    db = pymysql.connect("localhost","root","123321","big4")

    #使用cursor创建一个游标对象
    cursor = db.cursor()
    i = 0;
    while i <100000:
        sql = "insert into ceshi values(%d,'%s')"%(i%100,'tom'+str(i));
        cursor.execute(sql)
        i+=1
    #使用execute方法执行sql查询


    db.commit()
except:
    db.rollback()
finally:
    db.close()

db.close()