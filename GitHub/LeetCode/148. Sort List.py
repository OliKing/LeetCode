#!/usr/bin/env python
#_*_coding:utf-8_*_

def maxProduct( nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    if not nums:
        return None
    n = len(nums)
    dp = [[-float('INF') for i in range(n)] for j in range(n)]
    for i in range(n):
        for j in range(i, n):
            if i == j:
                dp[i][j] = nums[i]
            else:
                dp[i][j] = dp[i][j - 1] * nums[j]
    return dp

x = maxProduct([2,3,-2,4])
print(max(x))
print(x)