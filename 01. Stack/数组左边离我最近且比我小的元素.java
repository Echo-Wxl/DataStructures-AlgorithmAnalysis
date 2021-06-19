/*
 * 题目：给定一个数组，要找到这个数组里面每个元素左边比我小的元素的位置
 * - 注意：是左边第一个比我小的，如果有多个的话
 * - 如果没有，那么用-1表示。
 *
 * 返回：一个数组，表示左边比我小的数的下标位置
 *
 * 输入：[5, 6]
 * 输出：[-1, 0]
 * 解释：A[0] = 5，左边比我小的元素没有, 所以记录为 = -1
 *       A[1] = 6, 左边比我小的元素为A[0] = 5，所以记录为   = 0
 *       所以返回值是[-1, 0]
 */

class Solution {
    public int[] findLeftSmall(int[] A) {
        if (A == null || A.length) {
            return new int[0];
        }
        int N = A.length;
        int[] ans = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = N-1; i >= 0; i--) {
            int cur = A[i];
            while (!stack.isEmpty() || A[stack.peek()] > cur) {
                ans[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.peek()] = -1;
            stack.pop();
        }
        return ans;
    }
}