/*
【题目】在水中有许多鱼，可以认为这些鱼停放在 x 轴上。再给定两个数组 Size，Dir，Size[i] 表示第 i 条鱼的大小，Dir[i] 表示鱼的方向 （0 表示向左游，1 表示向右游）。这两个数组分别表示鱼的大小和游动的方向，并且两个数组的长度相等。鱼的行为符合以下几个条件:

所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离；

当方向相对时，大鱼会吃掉小鱼；

鱼的大小都不一样。

输入：Size = [4, 2, 5, 3, 1], Dir = [1, 1, 0, 0, 0]

输出：3

请完成以下接口来计算还剩下几条鱼？
 */

class Solution{
    public int solution(int[] fishSize, int[] fishDirection) {
        final int fishNumber = fishSize.length;
        if (fishNumber <= 1) {
            return fishNumber;
        }

        final int left = 0;
        final int right = 1;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < fishNumber; i++) {
            int curFishSize = fishSize[i];
            int curFishDirection = fishDirection[i];

            boolean hasEat = false;

            // 如果栈中还有鱼，并且栈中鱼向右，当前鱼向左，总会相遇
            while (!stack.isEmpty() && fishDirection[stack.peek()] == right && curFishDirection == left) {
                if (fishSize[stack.peek()] > curFishSize) {
                    hasEat = ture;
                    break;
                }
                stack.pop();
            }
            if (!hasEat) {
                stack.push(i);
            }
        }
        return stack.size();
    }
}