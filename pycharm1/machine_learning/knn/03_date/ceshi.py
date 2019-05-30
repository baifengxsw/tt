#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import math

import random
from numpy import *
import os

# 进行数值的归一化操作返回相应的矩阵
def autoNorm(dataSet):
    print("------------- 对数据进行归一化")
    dataSet = array(dataSet,dtype= float)
    minvals = dataSet.min(0)  # 得到每一列的最小值
    maxvals = dataSet.max(0)  # 得到每一列的最大值
    ranges = maxvals - minvals
    returnMat = zeros(shape(dataSet))
    dataSetLen = dataSet.shape[0]
    returnMat = dataSet - tile(minvals, (dataSetLen, 1))
    returnMat = returnMat / tile(ranges, (dataSetLen, 1))
    print("returnMat")
    print(returnMat)
    retMat = []
    for line in returnMat:
        list = line
        if 1 not in list and 0 not in list:
            retMat.append(line)
    print(retMat)
    m = []
    for line in retMat:
        lines = []
        lines.append([line[0]])
        print(line[0])
        lines.append(line[1:5].tolist())
        print(line[1:5])
        m.append(lines)
        print(lines)
    print("----------------------------------归一化结束")
    return m, maxvals, minvals
if __name__ == '__main__':
    pat = [

        [7, 4, 3, 1, 2],
        [8, 25, 6, 7, 8],
        [10, 7, 5, 4, 5],
        [22, 16, 7, 6, 3],
        [23, 36, 4, 5, 1],
        [45, 6, 7, 6, 3],
        [27, 4, 3, 5, 9],
        [13, 40, 50, 60, 4],
    ]
    a = [1,2,3,4]
    b = [1,2,3,4]
    print(a++b)
    '''
    m,maxVals,minVals = autoNorm(pat)
    print("--------------")
    print(m)
    print(minVals)
    print(maxVals)
    '''
    '''
    m = []
    for line in pat:
        lines = []
        lines.append([line[0]])
        lines.append(line[1:4])
        m.append(lines)

    print(m)
    '''
'''
    pat = array(pat,dtype = float)
    returnMat,maxvals,minvals = autoNorm(pat)
    print(returnMat)
    print(maxvals)
    print(minvals)
    print("-----------------------------------")
    for line in returnMat:
        print(line)
    print("------------------------------------")
    for line in returnMat:
        if 1 not in line and 0 not in line:
            print(line)
'''
    #print([i[0] for i in pat])
    #pat = [i[0] for i in pat]
    #pat = array(pat,dtype=float)

    #normMat, ranges, minVals  = autoNorm(pat)
    #print(normMat)
    #print(minVals)

    #print("-------------------------------")
    #m = []
    #for line in pat:
        #print(line[1])
        #m.append(line[1])
    #print(m)
    #print("pat:")
    #print(m)

    #m = array(m, dtype=float)
    #normMat, ranges, minVals = autoNorm(m)
    #print(normMat)
    #print(minVals)
