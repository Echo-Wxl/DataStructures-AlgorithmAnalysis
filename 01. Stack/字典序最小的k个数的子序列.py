"""
给定一个正整数数组和 k，要求依次取出 k 个数，输出其中数组的一个子序列，需要满足：1. 长度为 k；2.字典序最小。

输入：nums = [3,5,2,6], k = 2
输出：[2,6]

解释：在所有可能的解：{[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 字典序最小。

所谓字典序就是，给定两个数组：x = [x1,x2,x3,x4]，y = [y1,y2,y3,y4]，如果 0 ≤ p < i，xp == yp 且 xi < yi，那么我们认为 x 的字典序小于 y。
"""


def find_small_seq(arr, k):
    if len(arr) < k:
        return arr

    ans = [0] * k
    stack = list()

    for i in range(0, len(arr)):
        cur = arr[i]
        left = len(arr) - i
        while len(stack) > 0 and (left + len(stack)) > k and stack[-1] > cur:
            stack.pop()

        stack.append(cur)

    while len(stack) > k:
        stack.pop()

    return ans


if __name__ == '__main__':
    assert [1, 2, 3] == find_small_seq([9, 2, 4, 5, 1, 2, 6, 3, 100, 4], 3)
    assert [1, 2] == find_small_seq([9, 2, 4, 5, 1, 2, 6, 3, 100, 4], 2)
    assert [1] == find_small_seq([9, 2, 4, 5, 1, 2, 6, 3, 100, 4], 1)