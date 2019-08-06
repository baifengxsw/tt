#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng

import  os
import glob

dir = os.path.dirname(__file__)
print(os.path.join(dir,'*.a.txt'))
print(glob.glob(os.path.join(dir,'*.a.txt')))

os.remove()