/*
 * 题目：给定一个数组，要找到这个数组里面每个元素右边比我大的元素的位置
 * - 注意：是右边第一个比我大的，如果有多个的话
 * - 如果没有，那么用-1表示。
 * 返回：一个数组，表示右边比我大的数的下标位置
 *
 * 输入：[5, 6]
 * 输出：[1, -1]
 * 解释：A[0] = 5，右边比我大的是A[1] = 6, 所以记录为 = 1
 *       A[1] = 6, 右边比我大的元素没有，所以记录为   = -1
 *       所以返回值是[1, -1]
 */

class Solution{
    public int[] findRightLarge(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }

        int[] ans = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A; i++) {
            int cur = A[i];
            while (!stack.isEmpty() || A[stack.peek()] < cur) {
                ans[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.peek()] = -1;
            stack.pop();
        }
        return stack.size();
    }
}