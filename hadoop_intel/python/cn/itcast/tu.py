#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author:baifeng
#@Date:2019/5/26

from pyspark.sql import Row
import matplotlib.pyplot as plt
import numpy as np
import pylab as P
plt.rcdefaults()
dataDir ="file:///home/centos/ml-data/ml-1m/users.dat"
lines = sc.textFile(dataDir)
splitLines = lines.map(lambda l: l.split("::"))
usersRDD = splitLines.map(lambda p: Row(id=p[0],gender=p[1],age=int(p[2]), occupation=p[3], zipcode=p[4]))
usersDF = spark.createDataFrame(usersRDD)
usersDF.createOrReplaceTempView("users")
usersDF.show()