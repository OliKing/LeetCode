#!/usr/bin/env python
#_*_coding:utf-8_*_
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        count = 0
        l1, l2 = ListNode(0), ListNode(0)
        p, q = l1, l2
        cur = head
        while cur:
            if count % 2 == 0:
                p.next = cur
                cur = cur.next
                p = p.next
                count += 1
            else:
                q.next = cur
                cur = cur.next
                q = q.next
                count += 1
        p.next = None
        q.next = None
        l3 = ListNode(0)
        node = l3
        count = 0
        # while l1:
        #     print(l1.val)
        #     l1 = l1.next
        while l1.next:
            if l2.next and count % 2 == 0:
                node.next = l2.next
                l2.next = l2.next.next
                node = node.next
                count += 1
            else:
                node.next = l1.next
                node = node.next
                l1.next = l1.next.next
                count += 1
        return l3.next


n = [1, 2, 3, 4]
head = ListNode(0)
p = head
for i in range(len(n)):
    cur = ListNode(n[i])
    p.next = cur
    p = p.next
no = Solution()
res = no.swapPairs(head.next)
while res:
    print(res.val)
    res = res.next
