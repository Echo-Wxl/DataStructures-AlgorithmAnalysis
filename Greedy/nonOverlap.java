/*
【题目】给定一系列区间，请你选一个子集，使得这个子集里面区间都不相互重叠，并且这个子集里面元素个数最多。不重叠的定义：区间 [3,4] 和 [4,5] 就是不重叠。
输入：A = [[1,2],[2, 3], [3,4], [1,3]
输出：3
解释：最多只能选出 3 个区间相互不重叠[1,2], [2,3], [3,4]。
 */

class Solution {
    public int nonOverlapIntervals(int[][] A) {
        final int N = A==null?0:A.length;
        // 按照end排序
        Arrays.sort(A, (o1, o2) -> o1[1] == o2[1] ? 0 : (o1[1] < o2[1] ? -1 : 1));

        int maxEnd = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            final int start = A[i][0];
            if (maxEnd <= start) {
                maxEnd = A[i][1];
                ans++;
            }
        }
        return ans;
    }

    public int nonOverlapIntervals(int[][] A) {
        final int N = A==null ? 0:A.length;
        // 根据start来排序，需要逆序进行
        Arrays.sort(A, (o1, o2) -> o1[0] == o2[0] ? 0 : (o1[0] < o2[0] ? -1 : 1));

        int preStart = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = N-1; i >= 0 ; i--) {
            final int end = A[i][1];
            if (preStart >= end) {
                preStart = A[i][0];
                ans++;
            }
        }
        return ans;
    }
}