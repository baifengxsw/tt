#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng

with open('a.txt','r') as inf, open('b.txt','w') as outf:
    for line in inf:
        print(line , end='')
        #如果从文件开始读 ，那么其中必定带着换行符
        outf.write(' '.join( [item.capitalize() for item in line.split()]))
        outf.write('\n')
