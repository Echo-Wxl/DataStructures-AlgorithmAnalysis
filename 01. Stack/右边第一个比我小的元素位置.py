"""
一个整数数组 A，找到每个元素：右边第一个比我小的下标位置，没有则用 -1 表示。

输入：[5, 2]

输出：[1, -1]

解释：因为元素 5 的右边离我最近且比我小的位置应该是 A[1]，最后一个元素 2 右边没有比 2 小的元素，所以应该输出 -1。
"""
from typing import List


def find_right_small(arr: List) -> List:
    if not arr or len(arr) == 0:
        return arr

    ans = [0] * len(arr)

    stack = list()

    for i in range(len(arr)):
        cur = arr[i]
        while len(stack) > 0 and arr[stack[-1]] > cur:
            ans[stack[-1]] = i
            stack.pop()
        stack.append(i)

    while len(stack) > 0:
        ans[stack[-1]] = -1
        stack.pop()

    return ans


def find_right_small1(arr: List):
    ans = [-1] * len(arr)
    stack = list()

    for i in range(len(arr)):
        cur = arr[i]
        while len(stack) > 0 and arr[stack[-1]] > cur:
            ans[stack[-1]] = i
            stack.pop()

        stack.append(i)

    return ans


if __name__ == '__main__':
    assert [5, 5, 5, 4, 5, -1, -1] == find_right_small1([1, 2, 4, 9, 4, 0, 5])
