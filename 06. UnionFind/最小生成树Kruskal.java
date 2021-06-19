/*
【题目】给定一个图的点集，边集和权重，返回构建最小生成树的代价。

输入：N = 2， conn = [[1, 2, 37], [2, 1, 17], [1, 2, 68]]

输出：17

解释：图中只有两个点 [1, 2]，当然是选择最小连接 [2, 1, 17]
 */
class Solution{
    private long cost = 0;
    private int[] F = null;

    private void Init(int n) {
        F = new int[n];
        for (int i = 0; i < n; i++) {
            F[i] = i;
        }
        cost = 0;
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
        }
        F[Find(x)] = Find(y);
    }

    public long Kruskal(int n, int m, int[][] conn) {
        Init(n);

        Arrays.sort(conn, 0, (o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < m; i++) {
            Union(conn[i][0], conn[i][1], conn[i][2]);
        }
        return cost;
    }
}