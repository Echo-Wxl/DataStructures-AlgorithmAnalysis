/*
【题目】园区里面有很多大楼，编号从 1~N。第 i 大楼可以自己花钱买路由器上网，费用为 cost[i-1]，也可以从别的大楼拉一根网线来上网，比如大楼 a 和大楼 b 之间拉网线的费用为 c，表示为一条边 [a, b, c]。输入为每个大楼自己买路由器和拉网线的费用，请问，让所有大楼都能够上网的最小费用是多少？上网具有联通性，只要与能够上网的大楼连通，即可上网。

输入：cost = [1, 2, 3], edges = [[1,2,100], [2,3,3]]

输出：6

解释：最优方案是 1 号大楼买路由器 cost[0] = 1，2 号楼买路由器 cost[1] = 2，然后和 3 号楼之间可拉一根网线，费用为 3，所以一共花费 6 元。
 */
/*
思路：
添加虚拟结点0，添加结点0到各个结点的虚拟边，然后用最小生成树方法
 */
class Solution{
    private int[] F = null;
    private int totalCost = 0;

    private int Init(int n) {
        F = new int[n];
        for (int i = 0; i < n; i++) {
            F[i] = i;
        }
        totalCost = 0;
    }

    private int Find(int x) {
        if (x == F[x]) {
            return x;
        }
        F[x] = Find(F[x]);
        return F[x];
    }

    private void Union(int x, int y, int cost) {
        if (Find(x) != Find(y)) {
            totalCost += cost;
        }
        F[Find(x)] = Find(y);
    }

    public int minCostToSupplyWater(int N, int[] cost, int[][] es) {
        Init(N);

        int[][] conn = new int[es.length][3];

        for (int i = 0; i < es.length; i++) {
            conn[i][0] = es[i][0];
            conn[i][1] = es[i][1];
            conn[i][2] = es[i][2];
        }

        int to = es.length;
        for (int i = 1; i <= N; i++) {
            conn[to][0] = 0;
            conn[to][1] = i;
            conn[to][2] = cost[i - 1];
            to++;
        }

        Arrays.sort(conn, (o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < conn.length; i++) {
            Union(conn[i][0], conn[i][1], conn[i][2]);
        }
        return totalCost
    }
}