#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author:baifeng
#@Date:2019/5/26
import  os
from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

#导入自己生成的
from cn.itcast.hbaseThrift.thriftconfig.hbase import  THBaseService
from cn.itcast.hbaseThrift.thriftconfig.hbase.ttypes import *

transport = TSocket.TSocket('slave1', 9090)
transport = TTransport.TBufferedTransport(transport)
protocol = TBinaryProtocol.TBinaryProtocol(transport)
client = THBaseService.Client(protocol)
#打开传输端口
transport.open()
table = b'nn1:t6'
row = b'row17'
# v1= TColumnValue(b"f2",b"id",b'101')
# v2= TColumnValue(b"f2",b"id2",b'102')
# v3= TColumnValue(b"f2",b"id3",b'103')
# vals = [v1,v2,v3]
# put = TPut(row,vals)
# client.put(table,put)

col_id = TColumn(b"f2",b"id")
col_name = TColumn(b"f2",b"id2")
col_age = TColumn(b"f2",b"id3")

cols = [col_id,col_name,col_age]
get = TGet(row,cols)
res = client.get(table,get)

print(str(res))
print(bytes.decode(res.columnValues[0].qualifier))
print(bytes.decode(res.columnValues[0].family))
print(res.columnValues[0].timestamp)
print(bytes.decode(res.columnValues[0].value))


