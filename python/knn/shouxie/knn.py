#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
from numpy import *
from os import  listdir
def img2Vector(filename):
    returnVect = zeros((1,1024))
    fr = open(filename)
    for i in range(32):
        lineStr = fr.readline()
        for j in range(32):
            returnVect[0,32*i+j]=int(lineStr[j])
    return returnVect
def classify0(val ,dataSet,labels,k ):
    dataSetSize = dataSet.shape[0]
    diffMat  = tile(val,(dataSetSize,1)) - dataSet
    sqDiffMat = diffMat**2
    sqDistance = sqDiffMat.sum(axis=1)
    distances = sqDistance**0.5
    sortedDistIndices = distances.argsort()
    classCount = {}
    for i in range(k):
        voteLabel = labels[sortedDistIndices[i]]
        classCount[voteLabel]=classCount.get(voteLabel,0)+1
    sortedClassCount = sorted(classCount.items(),key =lambda item:item[1],reverse=True)
    return sortedClassCount[0][0]


def handwritingClassTest():
     hwLabels = []
     trainingFileList = listdir('trainingDigits')
     m = len(trainingFileList)
     trainingMat = zeros((m,1024))
     for i in range(m):
        fileNameStr = trainingFileList[i]
        fileStr = fileNameStr.split('.')[0]
        classNumStr = int(fileStr.split('_')[0])
        hwLabels.append(classNumStr)
        trainingMat[i,:] = img2Vector('trainingDigits/%s'%fileNameStr)
     testFileList = listdir('testDigits')
     errorCount = 0
     mTest = len(testFileList)
     for i  in range(mTest):
         fileNameStr = testFileList[i]
         fileStr = fileNameStr.split('.')[0]
         classNumStr = int (fileStr.split('_')[0])
         vectorUnderTest = img2Vector('testDigits/%s'%fileNameStr)
         classifierResult = classify0(vectorUnderTest,trainingMat,hwLabels,3)
         print("the classifier came back with :%d,the real answer is :%d"%(classifierResult,classNumStr))
         if(classifierResult!=classNumStr):
             errorCount +=1.0
     print("the total number of errors is:%d"%errorCount)
     print("the  total error rate is :%f"%(errorCount/float(mTest)))

