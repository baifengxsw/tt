#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng

class Solution:
    def IsPopOrder(self, pushV, popV):
        # write code
        stack = []
        pos = 0
        i = 0
        lens= len(pushV)
        for x in pushV:
            stack.append(x)
            while stack is not None and stack[-1] ==popV[pos]and pos <lens:
                stack.pop();
                pos+=1;
        return stack is None


arr = [1,2,3,4,5]
pop = [4,5,3,2,1]
s= Solution()
Solution.IsPopOrder(s,arr,pop)
