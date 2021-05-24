/*
有 N 种物品和一个容量是 V 的背包，每种物品都有无限件可用。

第 i 种物品的体积是 vi，价值是 wi。

求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
输出最大价值。

输入格式
第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。

接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 种物品的体积和价值。

输出格式
输出一个整数，表示最大价值。

数据范围
0<N,V≤1000
0<vi,wi≤1000
 */
class Solution{
    public int Slove(int N, int V, int[] v, int[] w) {
        int[] dp = new int[V + 1];

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int space = v[i]; space <= V; space++) {
                int oldSpace = space - v[i];
                int newSpace = space;
                dp[newSpace] = Math.max(dp[newSpace], dp[oldSpace] + w[i]);
                ans = Math.max(ans, dp[newSpace]);
            }
        }
        return ans;
    }
}
