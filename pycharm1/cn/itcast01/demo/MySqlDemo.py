#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng

import pymysql

#打开数据库连接


#使用cursor创建一个游标对象
cursor = db.cursor()

#使用execute方法执行sql查询
cursor.execute("select * from ceshi")

#使用fetchone方法获得单条数据
data = cursor.fetchmany(4)

print(data)

#关闭数据库连接
db.close()