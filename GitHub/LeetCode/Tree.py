#!/usr/bin/env python
#_*_coding:utf-8_*_
from collections import deque

#树节点定义
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


#二叉搜索树
class BST:
    def __init__(self, n):
        self.n = n

    #建立二叉搜索树
    def builtBst(self) -> TreeNode:
        if not self.n:
            return
        root = TreeNode(self.n[0])
        array = list()
        array.append(root)
        i = 1
        while array:
            curr = array.pop(0)
            if i < len(self.n) and i % 2 == 1:
                if self.n[i] is not None:
                    curr.left = TreeNode(self.n[i])
                    array.append(curr.left)
                i += 1
            if i < len(self.n) and i % 2 == 0:
                if self.n[i] is not None:
                    curr.right = TreeNode(self.n[i])
                    array.append(curr.right)
                i += 1
        return root

    def levelOrder(self, root: TreeNode) -> list:
        if not root:
            return []
        q = deque()
        res = []
        q.append(root)
        while q:
            curr = q.popleft()
            if curr:
                res.append(curr.val)
            else:
                res.append(None)
            #输出带None的list
            if curr:
                q.append(curr.left)
                q.append(curr.right)
        return res
            # #输出不带None的list
            # if curr.left:
            #     q.append(curr.left)
            # if curr.right:
            #     q.append(curr.right)
    #二叉树中序非递归遍历
    def inorderTraversal(self, root: TreeNode) -> list:
        stack = []
        p = root
        res = []
        while stack or p:
            while p:
                stack.append(p)
                p = p.left
            if stack:
                p = stack.pop()
                res.append(p.val)
                p = p.right
        return res

    #两个错误值，纠正成为二叉搜索树
    def recoverTree(self, root: TreeNode) -> None:

        # array[0], array[1]记录错误值
        # array[2]作为标签，实现arra[0]只记录第一个错误点，arra[1]只记录最后一个错误点
        # array[3]作为标签，决定是查找错误还是纠正错误
        # array[4]记录中序遍历的前一节点
        array = [0, 0, 1, 1, -float('inf')]
        self.recove_helper(root, array)
        array[3] = 0
        self.recove_helper(root, array)

    def recove_helper(self, root, array) -> None:
        if root.left:
            self.recove_helper(root.left, array)
        if array[3] and array[2] and (root.val < array[4]):
            array[0] = array[4]
            array[1] = root.val
            array[2] = 0
        elif array[3] and not array[2] and root.val < array[4]:
            array[1] = root.val
        elif not array[3] and root.val == array[0]:
            root.val = array[1]
        elif not array[3] and root.val == array[1]:
            root.val = array[0]
        array[4] = root.val
        if root.right:
            self.recove_helper(root.right, array)

    #两个错误值，纠正成为二叉搜索树，非递归方式实现
    def recoverTree_UR(self, root: TreeNode) -> None:
        q = deque()
        curr = root
        e1, e2, flag = 0, 0, 0
        min_ = TreeNode(-float('inf'))
        while q or curr:
            while curr:
                q.append(curr)
                curr = curr.left
            curr = q.pop()
            if curr.val < min_.val:
                if not flag:
                    e1 = min_
                    e2 = curr
                    flag = 1
                else:
                    e2 = curr
            min_ = curr
            curr = curr.right
        e1.val, e2.val = e2.val, e1.val


    #1-n生成所有可能的BST
    def generate_helper(self, start, end):
        result = []
        if start > end:
            result.append(None)
            return result

        for i in range(start, end + 1):
            # generate left and right sub tree
            leftTree = self.generate_helper(start, i - 1)
            rightTree = self.generate_helper(i + 1, end)
            # link left and right sub tree to root(i)
            for j in range(len(leftTree)):
                for k in range(len(rightTree)):
                    root = TreeNode(i)
                    root.left = leftTree[j]
                    root.right = rightTree[k]
                    result.append(root)
        return result

    def buildTreefromPreInorder(self, preorder: 'List[int]', inorder: 'List[int]') -> 'TreeNode':

        if not preorder:
            return None

        root = TreeNode(preorder[0])
        stack = []
        stack.append(root)

        pre = 1
        inor = 0
        while pre < len(preorder):
            curr = TreeNode(preorder[pre])
            pre += 1
            prev = None
            while stack and stack[-1].val == inorder[inor]:
                prev = stack.pop()
                inor += 1
            if prev:
                prev.right = curr
            else:
                stack[-1].left = curr

            stack.append(curr)
        return root
    def maxPathSum(self, root: TreeNode) -> int:
        def helper(node):
            if not node:
                return 0
            left = helper(node.left)
            right = helper(node.right)
            self.max = max(self.max, left + right)
            return max(left, right) + 1
        self.max = -float('inf')
        helper(root)
        return self.max


if __name__ == '__main__':
    n = [1, 2, 3, 4, 5, None, None, 9, None, 7, 8, None, None, None, None]
    b = BST(n)
    ro = b.builtBst()
    print(b.maxPathSum(ro))

