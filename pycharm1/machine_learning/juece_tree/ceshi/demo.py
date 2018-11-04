#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import  knn
def createDataSet():
    dataSet = [[1,1,'yes'],[1,1,'yes'],[1,0,'no'],[0,1,'no'],[0,1,'no']]
    labels = ['no surfacing','flippers']
    return dataSet,labels;

dataSet,labels= createDataSet()
knn.calcShannonEnt(dataSet)
knn.splitDataSet(dataSet,0,1)
print([example[-1] for example in dataSet])
myTree = knn.createTree(dataSet,labels)
print(myTree)



 