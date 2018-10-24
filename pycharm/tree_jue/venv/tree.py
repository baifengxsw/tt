#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
from math import log
def calcShannonEnt(dataSet):
    numEntries = len(dataSet)
    print('len:',numEntries)
    labelCounts = {}
    for featVec in dataSet:
        currentLabel = featVec[-1];
        labelCounts[currentLabel]=labelCounts.get(currentLabel,0)+1
    shannonEnt = 0.0

    for key in labelCounts:
        prob = float(labelCounts[key])/numEntries
        shannonEnt -=prob*log(prob,2)
    return shannonEnt

def splitDataSet(dataSet,axis,value):
    retDataSet = []
    for featVec in dataSet:
        if featVec[axis]==value:
            reducedFeatVec = featVec[:axis]
            reducedFeatVec.extend(featVec[axis+1:])
            retDataSet.append(reducedFeatVec)
    return retDataSet
def chooseBestFeatureToSplit(dataSet):
    numFeatures = len(dataSet[0])-1  #最后一列为标签列
    baseEntropy = calcShannonEnt(dataSet)
    bestInfoGain = 0.0;
    bestFeature = -1
    for i in range(numFeatures):
        featList = [example[i] for example in dataSet]
        uniqueVals = set(featList)
        newEntropy = 0.0
        for value in uniqueVals:
            subDataSet = splitDataSet(dataSet,i,value)
            prob = float(len(subDataSet))/len(dataSet)
            newEntropy += prob*calcShannonEnt(subDataSet)
        infoGain = baseEntropy - newEntropy
        if(infoGain>bestInfoGain):
            bestInfoGain = infoGain
            bestFeature = i;
        return bestFeature
def majorityCnt(clssList):
    classCount = {}
    for vote in clssList:
        classCount[vote]=classCount.get(vote,0)+1
    sortedClassCount = sorted(classCount.items(),key=lambda items:items[1],reverse=True)
    return sortedClassCount[0][0]
def createTree(dataSet,labels):
    classList = [example[-1] for example in dataSet]
    #如果类别相同则停止继续划分
    if classList.count(classList[0])==len(classList):
        return  classList[0]
    if len(dataSet[0])==1:
        return majorityCnt(classList)
    bestFeat = chooseBestFeatureToSplit(dataSet)
    bestFeatLabel = labels[bestFeat]
    myTree = {bestFeatLabel:{}}
    del(labels[bestFeat])
    featValues = [example[bestFeat]for example in dataSet]
    uniqueVals = set(featValues)
    for value in uniqueVals:
        subLabels = labels[:]
        myTree[bestFeatLabel][value] = createTree(splitDataSet(dataSet,bestFeat,value),subLabels)
    return myTree