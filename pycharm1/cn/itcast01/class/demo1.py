#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng

class Dog:
    #类似java中的静态成员变量
    name = "xia"
    def __init__(self,age):
        self.name = "wang"
        self.age = age
    def __del__(self):
        print("销毁对像")
#创建对象，等价于 new Dog()
d1  =  Dog(4)
print(d1.age)
print(hasattr(d1,"age"))
#python 内置函数 删除对象属性
#print(delattr(d1,"age"))
print(d1.age)
dict1 = Dog.__dict__
for dict11 in dict1.keys():
    print(dict11 + "----"+str(dict1[dict11]))

class Cat(Dog):
    def __init__(self):
        Dog.__init__(self,12)

    def run(self):
        print("wo zdssfsdf")

cat = Cat()
print(cat.name)