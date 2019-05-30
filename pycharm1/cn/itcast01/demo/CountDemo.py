#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import pymysql

conn = pymysql.connect(host='localhost', user='root', passwd='123321', db='big4', port=3306, charset='utf8')
try:
    # 关闭自动提交
    conn.autocommit(False)
    # 开始事务
    conn.begin()
    # 打开游标
    cur = conn.cursor()
    sql = "select count(*) from ceshi where id < 20"
    cur.execute(sql)
    res = cur.fetchone()
    print(res[0])
    conn.commit()
    cur.close

except Exception:
    conn.rollback()
finally:
    conn.close()

