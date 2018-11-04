#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
from math import log
'''
初始商
'''
def calcShannonEnt(dataSet):
    numEntries = len(dataSet)
    labelCounts = {}
    for featV in dataSet:
        currentLabel = featV[-1];
        labelCounts[currentLabel]=labelCounts.get(currentLabel,0) +1
    shannonRnt = 0.0
    for key in labelCounts.keys():
        prob = float(labelCounts[key])/numEntries
        shannonRnt -= prob*log(prob,2)
    return shannonRnt

'''
根据特征进行划分
'''
# 传回列表是因为python用的是引用 防止原值被更改
def splitDataSet(dataSet,axis,value):
    retDataSet = []
    for featVec in dataSet:
        if(featVec[axis]==value):
            reducedFeatVec = featVec[:axis]#不包括第axis位
            reducedFeatVec.extend(featVec[axis+1:])
            retDataSet.append(reducedFeatVec)
    return retDataSet

'''
选择最好的数据集划分方式

'''
def chooseBestFeatureToSplit(dataSet):
    numFeatures = len(dataSet[0])-1
    baseEntropy =calcShannonEnt(dataSet)
    bestInfoGain = 0.0
    bestFeature = -1
    for i in range(numFeatures):
        featList = [example[i] for example in dataSet]
        uniqueVals = set(featList)
        newEntropy = 0.0
        for value in uniqueVals:
            subDataSet = splitDataSet(dataSet,i,value)
            prob = len(subDataSet)/float(len(dataSet))
            newEntropy += prob*calcShannonEnt(subDataSet)
        infoGain = baseEntropy - newEntropy
        if(infoGain>bestInfoGain):
            bestInfoGain = infoGain
            bestFeature = i
    return bestFeature
#当前出现次数最多的

def majorityCnt(classList):
    classCount = {}
    for vote in classList:
        classCount[vote] = classCount.get(vote,0)+1
    sortedClassList = sorted(classCount.items(),key=lambda item:item[1],reverse=True)
    return sortedClassList[0][0]
'''
创建树的代码(递归形式)
'''
def createTree(dataSet,labels):
    classList = [example[-1] for example in dataSet]
    if classList.count(classList[0])==len(classList):
        return classList[0]
    if len(dataSet[0]) ==1:
        return majorityCnt(classList) #遍历完所有特征值时返回出现次数最多的
    bestFeat = chooseBestFeatureToSplit(dataSet)
    bestFeatLabel = labels[bestFeat]#拿到对应的特征
    myTree = {bestFeatLabel:{}}
    del(labels[bestFeat])#删除这个特征
    featValues = [example[bestFeat] for example in dataSet]
    uniqueVals = set(featValues)
    for value in uniqueVals:
        subLabels = labels[:]
        myTree[bestFeatLabel][value] = createTree(splitDataSet(dataSet,bestFeat,value),subLabels)
    return myTree
