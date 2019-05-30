#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng

if True :
    print("dsfdsfd"
          "sf" )

print("123"*2)

str = "sdfsf"
print(str[:])
#list = [1,3,4,"dsfdsf"]
#print(list.__len__())

s={"xia":1,"shuang":2}

print(s['xia'])
print(s.keys())
for str in s.values():
    print(str)

print("--------------")
b=4
jisuan = "(10+b)*b"
print(eval(jisuan))
sss = 1,3,2,3,4,5
print(1 in sss and 3 not in sss)
list1= list(sss)
print(list1)
ttt= tuple(sss)
print(ttt)

print("王永")

print(2/3)
print(2//3)
a =2
a **= 3
print(a)

age = 23
if age <20 :
    print(age)
elif 20<= age and age <=30:
    print(age)
else :
    print(age)

list2 = [1,2,3,4,5,6,7,8,9]
for l1 in list2:
    for l2 in list2:
        if(l2<=l1):
            print("%d x %d = %d"%(l1,l2,l1*l2),end="\t")
    print()

t1 = (1,2,3)
t2 = (1,3,54)
t3 = t1 + t2
print(t1[:6])
print(t3)
print(t1 *3)

print(u"王永新都是范德萨范德萨")
print(list2)
list3 = list1.extend(list2)
print(list2)

print(list1)
list1.remove(3)
print(list1)
cols = 3
rows = 4
list4 =[[ 0 for col in range(cols)] for row in range(rows)]
list5 = [1 for i in range(3)]
print(list5)
print(list4)

#IO 操作
file = open("e:/sample/data2.txt","a+")
lines = file.readlines()
for line in lines:
    print(line)

file.writ
file.close()
