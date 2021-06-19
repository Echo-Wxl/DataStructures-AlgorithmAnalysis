//给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。 
//
// 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。 
//
// 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时： 
//
// 
// 如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块 
// 如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块 
// 
//如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
//
// 
//
// 示例 1： 
//
// 
//输入：heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
//输出：4
//解释：从建筑物 0 出发，你可以按此方案完成旅程：
//- 不使用砖块或梯子到达建筑物 1 ，因为 4 >= 2
//- 使用 5 个砖块到达建筑物 2 。你必须使用砖块或梯子，因为 2 < 7
//- 不使用砖块或梯子到达建筑物 3 ，因为 7 >= 6
//- 使用唯一的梯子到达建筑物 4 。你必须使用砖块或梯子，因为 6 < 9
//无法越过建筑物 4 ，因为没有更多砖块或梯子。
// 
//
// 示例 2： 
//
// 
//输入：heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
//输出：7
// 
//
// 示例 3： 
//
// 
//输入：heights = [14,3,19,3], bricks = 17, ladders = 0
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <= 105 
// 1 <= heights[i] <= 106 
// 0 <= bricks <= 109 
// 0 <= ladders <= heights.length 
// 
// Related Topics 堆 二分查找 
// 👍 56 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (heights == null || heights.length == 0) {
            return -1;
        }
        final int N = heights.length;

        Queue<Integer> Q = new PriorityQueue<>((o1, o2)->o2-o1);
        int lastPos = 0;
        int preHeight = heights[0];
        int qSum = 0;
        for (int i = 0; i < N; i++) {
            int curHeight = heights[i];
            if (curHeight <= preHeight) {
                lastPos = i;
            } else {
                int delta = curHeight - preHeight;
                qSum += delta;
                Q.offer(delta);
                while (qSum > bricks && ladders > 0) {
                    qSum -= Q.poll();
                    ladders--;
                }
                if (qSum <= bricks) {
                    lastPos = i;
                } else {
                    break;
                }
            }
            preHeight = curHeight;
        }
        return lastPos;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
