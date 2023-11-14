from typing import List


def find_right_big(arr: List) -> List:
    if not arr or len(arr) == 0:
        return arr

    ans = [0] * len(arr)
    stack = list()

    for i in range(len(arr)):
        cur = arr[i]

        while len(stack) > 0 and arr[stack[-1]] < cur:
            ans[stack[-1]] = i
            stack.pop()

        stack.append(i)

    while len(stack) > 0:
        ans[stack[-1]] = -1
        stack.pop()

    return ans

