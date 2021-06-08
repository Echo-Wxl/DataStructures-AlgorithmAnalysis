//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， w
//i 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
// Related Topics 堆 深度优先搜索 广度优先搜索 图 
// 👍 266 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Edge {
        public int to;
        public int cost;

        public Edge(int a, int b) {
            to = a;
            cost = b;
        }
    }

    // times实际上是边集
    public int networkDelayTime(int[][] times, int N, int k) {
        if (times == null || times.length == 0) {
            return 0;
        }

        List<List<Edge>> G = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            G.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            final int from = times[i][0], to = times[i][1], cost = times[i][2];
            G.get(from).add(new Edge(to, cost));
        }

        final int INF = Integer.MAX_VALUE / 2;
        int[] ans = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            ans[i] = INF;
        }

        Queue<Integer> Q = new PriorityQueue<>((v1, v2) -> {
            return ans[v1] - ans[v2];
        });

        Q.add(k);
        ans[k] = 0;

        while (!Q.isEmpty()) {
            int cur = Q.poll();
            for (Edge e : G.get(cur)) {
                final int next = e.to, cost = e.cost;
                final int transCost = ans[cur] + cost;
                if (transCost < ans[next]) {
                    ans[next] = transCost;
                    Q.add(next);
                }
            }
        }

        int maxValue = -1;
        for (int i = 1; i <= N; i++) {
            maxValue = Math.max(maxValue, ans[i]);
        }

        return maxValue == INF ? -1 : maxValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
