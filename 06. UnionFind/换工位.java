/*
【题目】因为要实施结对编程，想让两个员工的工位挨在一起：要求 [0,1] 员工坐在一起，[2, 3] 员工坐在一起，以此类推。不过挨着具体坐的位置并不重要，只要能挨在一起就可以了。比如 [0, 1, 3, 2] 与 [2, 3, 1, 0] 都是满足要求的。现在给定一个数组 A[]，求换工位的最少次数，尽量让两个员工坐在一起。（给定 N 个员工，他们的编号总是 [0~N-1] ，并且 N 总是偶数）。

输入：A[] = [0, 3, 2, 1]

输出：1

解释：只需要换 1 次就可以了，比如，将 0 号员工与 2 号员工交换。
 */
class Solution{
    private int[] F = null;
    private int count = 0;

    private void Init(int n) {
        F = new int[n];
        for (int i = 0; i < n; i++) {
            F[i] = i - (i & 0x01);
        }
        count = n;
    }

    private int Find(int x) {
        if (x == F[x]) {
            return x;
        }
        F[x] = Find(F[x]);
        return F[x];
    }

    private void Union(int x, int y) {
        if (Find(x) != Find(y)) {
            count--;
        }
        F[Find(x)] = Find(y);
    }

    public int minSwapGouples(int[] A) {
        final int N = A == null ? 0: A.length;
        Init(N);
        for (int i = 0; i < N; i+=2) {
            Union(A[i], A[i+1]);
        }
        return count;
    }
}