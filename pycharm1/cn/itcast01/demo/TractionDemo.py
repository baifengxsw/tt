#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng

'''
执行事务的管理，手动提交事务，回滚事务

'''
import pymysql
try:
    connection = pymysql.connect("localhost","root","123321","big4")
    #关闭自动提交
    connection.autocommit(False)
    #开始事务
    connection.begin()
    #打开游标
    cur = connection.cursor()
    sql = "delete from ceshi where id > 10"
    cur.execute(sql)
    connection.commit()
except Exception:
    connection.rollback()
finally:
    connection.close()
    cur.close()

 