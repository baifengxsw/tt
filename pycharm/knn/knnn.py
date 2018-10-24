#coding=utf-8
#简单来说，k临近算法采用测量不同特征值之间的距离方法进行分类
#它的工作原理是，存在一个样本数据集合，也称训练样品集，且每个样本集中每个数据都存在标签，就是我们知道样本
# 集每一数据和对应分类的关系
#输入没有标签的新数据后，将新数据的每个特征与样本集中数据对应的特征进行比较，然后算法，提取样本集集中特征最相似
#的分类标签，一般来说我们只选择样本数据集中前k个最相似的数据
from numpy import *
import  operator
def createDataSet():#样本数据
    group = array([[1.,1.1],[1.,1.],[0.,0.],[0.,0.1]])
    labels = ['A','A','B','B']
    return group,labels
#k-临近算法
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

