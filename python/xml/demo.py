#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import xml.dom.minidom
from xml.dom.minidom import parse
#读取文件
DomTree = xml.dom.minidom.parse("1.xml")
#得到文件对象
doc = DomTree.documentElement
#显示子元素
for ele in doc.childModes:
        if ele.no
