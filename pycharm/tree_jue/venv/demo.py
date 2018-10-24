#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import tree
def createDataSet():
    dataSet = [[1,1,'yes'],[1,1,'yes'],[1,0,'no'],[0,1,'no'],[0,1,'no']]
    labels = ['no surfacing','flippers']
    return dataSet,labels
mydat, labels = createDataSet()
print(mydat)
print(labels)
print('****************************************')
print(tree.calcShannonEnt(mydat))
print(tree.splitDataSet(mydat,0,1))
print('-------------------------------------------------')
print(tree.splitDataSet(mydat,0,0))
print(tree.chooseBestFeatureToSplit(mydat))
print('--------------------------------------')
myTree = tree.createTree(mydat,labels)
print(myTree)
 