#!/usr/bin/env python
#_*_coding:utf-8_*_

# 算法思想通过dict和双链表来实现LRU
class DLList:
    def __init__(self, k, v):
        self.k = k
        self.val = v
        self.prev = None
        self.next = None


class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.dic = {}
        self.head = DLList(0, 0)
        self.node = DLList(0, 0)
        self.head.next = self.node
        self.node.prev = self.head

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key not in self.dic:
            return -1
        else:
            cur = self.dic[key]
            self.remove(cur)
            self.add(cur)
            return cur.val

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        # if len(self.dic) < self.capacity:
        #     if key not in self.dic:
        #         cur = DLList(key, value)
        #         self.add(cur)
        #         self.dic[key] = cur
        #     else:
        #         cur = self.dic[key]
        #         cur.val = value
        #         self.remove(cur)
        #         self.add(cur)
        #         self.dic[key] = cur
        # else:
        #     temp = self.head.next
        #     del self.dic[temp.k]
        #     self.remove(self.head.next)
        #     cur = DLList(key, value)
        #     self.add(cur)
        #     self.dic[key] = cur
        if key in self.dic:
            self.remove(self.dic[key])
        cur = DLList(key, value)
        self.add(cur)
        self.dic[key] = cur
        if len(self.dic) > self.capacity:
            temp = self.head.next
            self.remove(temp)
            del self.dic[temp.k]

    def remove(self, cur):
        p = cur.prev
        n = cur.next
        p.next = n
        n.prev = p

    def add(self, cur):
        p = self.node.prev
        p.next = cur
        cur.prev = p
        cur.next = self.node
        self.node.prev = cur
