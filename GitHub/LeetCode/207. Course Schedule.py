#!/usr/bin/env python
#_*_coding:utf-8_*_

import collections
def canFinish( numCourses, prerequisites):
    """
    :type numCourses: int
    :type prerequisites: List[List[int]]
    :rtype: bool
    """
    grah = [[] for i in range(numCourses)]
    ind = [0] * numCourses
    od = collections.deque()
    for i in range(len(prerequisites)):
        grah[prerequisites[i][0]].append(prerequisites[i][1])
        ind[prerequisites[i][1]] += 1
    for i in range(numCourses):
        if ind[i] == 0:
            od.appendleft(i)
    while od:
        t = od.popleft()
        for j in range(len(grah[t])):
            ind[grah[t][j]] -= 1
            if ind[grah[t][j]] == 0:
                od.appendleft(grah[t][j])
    for i in range(numCourses):
        if ind[i] != 0:
            return False
    return True

print(canFinish(2,[[1,0]]))