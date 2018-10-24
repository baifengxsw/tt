#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import knnn
group,labels = knnn.createDataSet()
print(group)
print(labels)
result = knnn.classify([1,1],group,labels,3)
print(result)

# randMat = random.rand(5,5)
# print(randMat)
# print(randMat.shape[0])
# dic ={'xia':4,'shuang':2,'wu':3}
# sortedDic = sorted(dic.items(),key=lambda item:item[0],reverse=True)
# print(sortedDic)
# print('-------------------------')
# print(sortedDic[0][0])



