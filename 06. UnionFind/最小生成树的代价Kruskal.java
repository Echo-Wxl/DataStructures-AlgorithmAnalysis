/*
给定点集和边集，求最小生成树的代价，如果最后不能生成最小生成树，那么返回MAX_INT
 */

class Solution{
    private long cost = 0;
    private int count = 0;
    private int[] F = null;

    private void Init(int n) {
        F = new int[n];
        for (int i = 0; i < n; i++) {
            F[i] = i;
        }
        cost = 0;
        count = n;
    }

    private int Find(int x) {
        if (x == F[x]) {
            return x;
        }
        F[x] = Find(F[x]);
        return F[x];
    }

    private void Union(int x, int y, int pay) {
        if (Find(x) != Find(y)) {
            cost += pay;
            count--;
        }
        F[Find(x)] = Find(y);
    }

    public long Kruskal(int n, int m, int[][] conn) {
        Init(n);

        Arrays.sort(conn, 0, (o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < m; i++) {
            Union(conn[i][0], conn[i][1], conn[i][2]);
        }
        return count <=1 cost:Integer.MAX_VALUE;
    }
}