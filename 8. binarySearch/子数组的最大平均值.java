/*
【题目】给定一个正整数数组 A 和 k，要求找到子数组，输出其最大平均值，并且子数组长度要满足大于等于 k。

输入：A = [1,12,-5,-6,50,3], k = 3

输出：15.667

解释：在所有长度大于等于 3 的子数组中，(-6 + 50 + 3) / 3 = 15.667 是最大的。
 */
class Solution{
    private int getC(int[] A, int[] B, double m, int k) {
        final int N = A.length;
        for (int i = 0; i < N; i++) {
            B[i] = (double)A[i]-m;
        }

        for (int i = 1; i < N; i++) {
            B[i] += B[i - 1];
        }

        double preMin = 0;
        for (int i = k-1; i < N; i++) {
            if (B[i] >= preMin) {
                return 0;
            }
            preMin = Math.min(preMin, B[i + 1 - k]);
        }
        return 1;
    }

    public double maxAverage(int[] A, int k) {
        final int N = A==null ? 0: A.length;
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            small = Math.min(small, A[i]);
            large = Math.max(large, A[i]);
        }

        double[] B = new double[N];
        double l = small, r = large+1.0;
        while ((r - l) > 1e-6) {
            double m = (l+r)/2.0;
            int mov = getC(A, B, m, k);
            if (mov <= 0) {
                l = m;
            } else {
                r = m;
            }
        }
        return Math.abs(l)<1e-6?0:l;
    }
}