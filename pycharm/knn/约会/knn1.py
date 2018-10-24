#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
from numpy import*
import matplotlib


#首先实现从文件的导入
def file2matrix(filename):
    fr = open(filename)
    arrayLines = fr.readlines()
    numberOfLines = len(arrayLines)
    returnMat = zeros((numberOfLines,3))
    classLabelVector = []
    index = 0
    for line in arrayLines:
        line = line.strip()
        listFromLine = line.split('\t')
        returnMat[index,:] = listFromLine[0:3] #这里指的是所有列的第一行数据
        classLabelVector.append(int(listFromLine[-1]))
        index +=1
    return returnMat,classLabelVector


def autoNorm(dataSet):
    minVals = dataSet.min(0)#相反
    maxVals = dataSet.max(0)
    ranges = maxVals - minVals
    normDataSet = zeros(shape(dataSet))
    m = dataSet.shape[0]  # 行0列1
    normDataSet = dataSet - tile(minVals, (m, 1))
    normDataSet = normDataSet / tile(ranges, (m, 1))
    return normDataSet, ranges, minVals
def datingClassTest():
    hoRatio = 0.10
    datingDataMat,datingLabels = file2matrix('datingTestSet2.txt')
    normMat,ranges,minVals = autoNorm(datingDataMat)
    m = normMat.shape[0]
    numTestVecs = int (m*hoRatio)
    errorCount = 0.0
    for i in range(numTestVecs):
        classifierResult = classify(normMat[i,:],normMat[numTestVecs:m,:],datingLabels[numTestVecs:m],3)
        print("the classifier came back with:%d,the real answer is:%d"%(classifierResult,datingLabels[i]))
        if (classifierResult!=datingLabels[i]):
            errorCount +=1.0

    print("the total error rate is:%f"%(errorCount/numTestVecs))

def classify(inx,dataSet,labels,k):
    dataSetSize = dataSet.shape[0]
    diffMat = tile(inx,(dataSetSize,1)) - dataSet
    sqDiffMat = diffMat**2
    sqDistance = sqDiffMat.sum(axis=1)
    distance = sqDistance**0.5
    sortedDistIndicies = distance.argsort()
    classCount = {}
    #k表示选取几个点作为出现频率最高的类别作为预测分类
    for i in range(k):
        voteLabel = labels[sortedDistIndicies[i]]
        classCount[voteLabel] = classCount.get(voteLabel,0)+1  #学习这个写法
    sortedClassCount=sorted(classCount.items(),key=lambda item:item[1],reverse=True)
    return sortedClassCount[0][0]
def classifyPerson():
    resultList = [ 'not at all','in small doses','in large dosws']
    percentTats = float(input("percentage of time spent playing video games?*"))
    ffMiles = float(input("frequent flier miles earned per year?"))
    iceCream = float(input("liters of ice cream consumed per year?"))
    datingDataMat,datingLabels = file2matrix('datingTestSet2.txt')
    normMat,ranges,minVals = autoNorm(datingDataMat)
    inArr = array([ffMiles,percentTats,iceCream])
    classifierResult = classify((inArr-minVals)/ranges,normMat,datingLabels,3);
    print("You will probably like this person:",resultList[classifierResult-1])
