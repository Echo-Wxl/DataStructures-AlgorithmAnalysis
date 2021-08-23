/*
【题目】一个整数数组 A，找到每个元素：右边第一个比我小的下标位置，没有则用 -1 表示。

输入：[5, 2]

输出：[1, -1]

解释：因为元素 5 的右边离我最近且比我小的位置应该是 A[1]，最后一个元素 2 右边没有比 2 小的元素，所以应该输出 -1。
 */

class Solution{
    public int[] findRightSmall(int[] A) {
        final int N = A==null ? 0:A.length;
        if (N <= 1) {
            return A;
        }

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            int cur = A[i];
            while (!stack.isEmpty() && A[stack.peek()] > cur) {
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