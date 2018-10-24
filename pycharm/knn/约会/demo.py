#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
from imp import reload
import knn1

from numpy import array
import matplotlib
import matplotlib.pyplot as plt
reload(knn1)
datingDataMat,datingLabels = knn1.file2matrix('datingTestSet2.txt')
print(datingDataMat)
print(datingLabels)
fig = plt.figure()
ax = fig.add_subplot(221) #add_subplot(nmi) 代表将画布分割成n行m列，画在从左到右从上到下的第i块
ax2 = fig.add_subplot(222)
ax3 = fig.add_subplot(223)
ax4 = fig.add_subplot(224)

ax.scatter(datingDataMat[:,1], datingDataMat[:,2])#[:,1],[:,2]代表datingDataMat的第二、三列数据
ax2.scatter(datingDataMat[:,1], datingDataMat[:,2],15.0*array(datingLabels),15.0*array(datingLabels)) #数据乘以特征值，更好的区别特征数据

ax3.scatter(datingDataMat[:,0], datingDataMat[:,2],15.0*array(datingLabels),15.0*array(datingLabels))
ax4.scatter(datingDataMat[:,0], datingDataMat[:,1],15.0*array(datingLabels),15.0*array(datingLabels))
plt.show()

normMat,range,minVals = knn1.autoNorm(datingDataMat)
knn1.datingClassTest()
knn1.classifyPerson()
