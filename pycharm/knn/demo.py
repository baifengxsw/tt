#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import knnn
group,labels = knnn.createDataSet()
print(group)
print(labels)
result = knnn.classify([1,1],group,labels,3)
print("*"*50)
print(result)
l = [1,2,3,4,5,6]
ret = l[0:3]
print(ret)
print("*"*50)
from numpy import *

# 一维向量
v1 = array([1, 0, 1])
v11 = array([1, 1, 1])

# 2*3矩阵
v2 = array([[1, 1, 2], [1, 1, 0]])

# 向量加法
print("一维向量相加： ", v1 + v11)
print("一维加二维： ", v1 + v2)

# 向量减法
print("一维向量相减： ", v1 - v11)
print("一维减二维： ", v1 - v2)

# randMat = random.rand(5,5)
# print(randMat)
# print(randMat.shape[0])
# dic ={'xia':4,'shuang':2,'wu':3}
# sortedDic = sorted(dic.items(),key=lambda item:item[0],reverse=True)
# print(sortedDic)
# print('-------------------------')
# print(sortedDic[0][0])



