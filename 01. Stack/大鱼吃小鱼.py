"""
在水中有许多鱼，可以认为这些鱼停放在 x 轴上。再给定两个数组 Size，Dir，
Size[i] 表示第 i 条鱼的大小，
Dir[i] 表示鱼的方向 （0 表示向左游，1 表示向右游）。
这两个数组分别表示鱼的大小和游动的方向，
并且两个数组的长度相等。鱼的行为符合以下几个条件:

所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离；

当方向相对时，大鱼会吃掉小鱼；

鱼的大小都不一样。

输入：Size = [4, 2, 5, 3, 1], Dir = [1, 1, 0, 0, 0]

输出：3
"""
from typing import List


def solution(fish_size: List, fish_dir: List) -> int:
    fish_num = len(fish_size)

    if fish_num <= 1:
        return fish_num

    left = 0
    right = 1

    stack = list()

    for i in range(fish_num):
        cur_fish_size = fish_size[i]
        cur_fish_dir = fish_dir[i]

        has_eat = False

        while len(stack) > 0 and fish_dir[stack[-1]] == right and cur_fish_dir == left:
            if fish_size[stack[-1]] > cur_fish_size:
                has_eat = True
                break
            stack.pop()

        if not has_eat:
            stack.append(i)

    return len(stack)


if __name__ == '__main__':
    Size = [4, 3, 2, 1, 5]
    Dir = [0, 1, 0, 0, 0]
    res = solution(Size, Dir)
    print(res)
