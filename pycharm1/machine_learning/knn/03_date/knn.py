#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
from numpy import *
import os

def file2matrix(filename):
    fr = open(filename)
    arrayLines = fr.readlines()
    numOfLines = len(arrayLines)
    returnMat = zeros((numOfLines,3))
    classLabels =[]
    index=0
    for line in arrayLines:
        line = line.strip()
        listFromLine = line.split("\t")
        returnMat[index,:] = listFromLine[0:3]#切片不包括右面
        classLabels.append(int(listFromLine[-1]))
        index += 1
    return returnMat,classLabels


def classify(inx,dataSet,labels,k):
    dataSetSize = dataSet.shape[0] #返回数据所对应有多少行
    diffMat = tile(inx,(dataSetSize,1)) - dataSet #tile 按后方的set 进行横向和竖直方向的赋值
    sqDiffMat = diffMat**2 #矩阵内部元素的平方
    sqDistance = sqDiffMat.sum(axis=1)#axis=1 是行所对应的相加
    distance = sqDistance**0.5
    sortedDistIndicies = distance.argsort()#对数据进行排序 返回对应的索引
    classCount = {}
    #k表示选取几个点作为出现频率最高的类别作为预测分类
    for i in range(k):
        voteLabel = labels[sortedDistIndicies[i]]
        classCount[voteLabel] = classCount.get(voteLabel,0)+1  #学习这个写法
    sortedClassCount=sorted(classCount.items(),key=lambda item:item[1],reverse=True)
    return sortedClassCount[0][0]

#进行数值的归一化操作
def autoNorm(dataSet):
    minvals = dataSet.min(0)#得到每一列的最小值
    maxvals = dataSet.max(0)
    ranges = maxvals - minvals
    returnMat = zeros(shape(dataSet))
    dataSetLen = dataSet.shape[0]
    returnMat = dataSet - tile(minvals,(dataSetLen,1))
    returnMat = returnMat /tile(ranges,(dataSetLen,1))
    return returnMat,ranges,minvals

def datingTest():
    ratio = 0.1
    datingDataMat ,datingLabels = file2matrix('datingTestSet2.txt')
    normMat,ranges,minVals = autoNorm(datingDataMat)
    m = normMat.shape[0]
    numTestVecs = int(m*ratio)
    errorCount = 0.0
    for i in range(numTestVecs):
        classResult = classify(normMat[i,:],normMat[numTestVecs:m,:],datingLabels[numTestVecs:m],3)
        print("the classResult value is {0} and the real value is {1}".format(classResult,datingLabels[i]))
        if classResult!=datingLabels[i]:
            errorCount += 1
    print("the total error num is {0} and the total error rate is {1}".format(errorCount,errorCount/float(numTestVecs)))


def classifyPerson():
    resultList = ['not at all','in small dose','in big dose']
    percentTats = float(input("please input the percentage of time spent playing video game"))
    ffMiles = float(input("frequent flier miles earned per year"))
    iceCream = float(input("liters of ice cream consumed per year"))
    datingDataMat,datingLabels = file2matrix("datingTestSet2.txt")
    normMat,ranges,minvals = autoNorm(datingDataMat)
    arr = array([ffMiles,percentTats,iceCream])
    classifierResult = classify((arr-minvals)/ranges,normMat,datingLabels,3)
    print("You will probably like this person {0}".format(resultList[classifierResult-1]))