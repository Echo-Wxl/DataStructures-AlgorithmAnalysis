/*
有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。

第 i 件物品的体积是 vi，价值是 wi。

求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
输出最大价值。

输入格式
第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。

接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。

输出格式
输出一个整数，表示最大价值。

数据范围
0<N,V≤1000
0<vi,wi≤1000
 */

class Solution{
    public int Solve(int N, int V, int[] v, int[] w) {
        int[] dp = new int[V + 1];

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int space = V; space >= v[i] ; space--) {
                int newSpace = space;
                int oldSpace = space - v[i];
                dp[newSpace] = Math.max(dp[newSpace], dp[oldSpace] + w[i]);
                ans = Math.max(ans, dp[newSpace]);
            }
        }
        return ans;
    }
}


// test code
public class Main {
    static private int pointsNumber = 0;
    static private int[][] conn = new int[7000][3];
    static private Solution s = new Solution();

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 背包的数目
            int N = sc.nextInt();
            if (N <= 0) {
                break;
            }
            // 容量
            int V = sc.nextInt();

            int[] v = new int[N];
            int[] w = new int[N];
            // 读入每个背包
            for (int i = 0; i < N; i++) {
                v[i] = sc.nextInt();
                w[i] = sc.nextInt();
            }

            System.out.println(s.Solve(N, V, v, w));
        }
    }
}