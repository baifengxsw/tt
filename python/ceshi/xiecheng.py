#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng

from collections import namedtuple
ResClass = namedtuple("Res","count average")
#子生成器
def averager():
        total = 0.0
        count = 0
        average = None
        while True:
                term = yield
                # None 是哨兵值
                if term is None:
                        break
                total += term
                count += 1
                average = total /count
        return ResClass(count,average)


def grouper(storages, key):
    while True:

        # 获取averager()返回的值
        storages[key] = yield from averager()


# 客户端代码
def client():
    process_data = {
        "boys_2": [39.0, 40.8, 43.2], "boys_1": [1, 38, 1.5, 1.32, 1.25]}
    storages = {}
    for k, v in process_data.items():
        # 或得协程
        coroutine = grouper(storages, k)
        # 预激活协程
        next(coroutine)


        for dt in v:
                coroutine.send(dt)
        coroutine.send(None)
    print(storages)

#run
client()
