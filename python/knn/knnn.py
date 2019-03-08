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
'''
len()：返回对象的长度，注意不是length()函数 
len([1,2,3])，返回值为3 
len([[1,2,3],[3,4,5]])，返回值为2

count()：计算包含对象个数 
[1,1,1,2].count(1)，返回值为3 
‘asddf’.count(‘d’)，返回值为2

size()和shape () 是numpy模块中才有的函数

size()：计算数组和矩阵所有数据的个数 
a = np.array([[1,2,3],[4,5,6]]) 
np.size(a)，返回值为 6 
np.size(a,1)，返回值为 3

shape ():得到矩阵每维的大小 
np. shape (a)，返回值为 (2,3)

另外要注意的是，shape和size既可以作为函数，也可以作为ndarray的属性 
a.size，返回值为 6, 
a.shape，返回值为 (2,3)
'''
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

