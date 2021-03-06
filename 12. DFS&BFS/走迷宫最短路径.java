/*
【题目】给定一个迷宫，其中 0 表示可能通过的地方，而 1 表示墙壁。请问，从左上角走到右下角的最短路径是什么样的？请依次输出行走的点坐标。

输入：A = [[0, 1], [0, 0]]

输出：ans = [[0, 0], [1, 0], [1,1]]
 */
class Node {
    public int r;
    public int c;
    public Node() {}
    public Node(int a, int b) {
        r = a;
        c = b;
    }
}
class Solution {
    private List<Node> shortPath = null;
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    // 深度clone一个java list.
    private List<Node> Clone(List<Node> a) {
        List<Node> ans = new ArrayList<Node>();
        for (int i = 0; i < a.size(); i++) {
            Node x = a.get(i);
            ans.add(new Node(x.r, x.c));
        }
        return ans;
    }
    /**
     * @param A     迷宫图
     * @param vis   访问记录
     * @param r     出发点(r, c)
     * @param c
     * @param tmp   走到r,c的路径
     */
    public void dfs(int[][] A, boolean[][] vis, int r, int c, List<Node> tmp) {
        final int R = A.length;
        final int C = A[0].length;
        // 如果已经走到终点
        if (r == R - 1 && c == C - 1) {
            if (shortPath == null || shortPath.size() > tmp.size()) {
                shortPath = Clone(tmp);
            }
            return;
        }
        // 接下来看当前出发点的四个选择
        for (int d = 0; d < 4; d++) {
            final int nr = r + dir[d][0];
            final int nc = c + dir[d][1];
            // 如果是越界的
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }
            // 如果是不能访问的
            // 或者说已经访问过了
            if (A[nr][nc] == 1 || vis[nr][nc] == true) {
                continue;
            }
            vis[nr][nc] = true;
            tmp.add(new Node(nr, nc));
            dfs(A, vis, nr, nc, tmp);
            vis[nr][nc] = false;
            tmp.remove(tmp.size()-1);
        }
    }
    /**
     * @param A     的迷宫图
     * @return      路径的长度，所有的路径会存放在ans
     */
    public List<Node> findMinPath(int[][] A) {
        List<Node> ans = null;
        if (A == null || A[0].length == 0) {
            return ans;
        }
        final int R = A.length;
        final int C = A[0].length;
        boolean[][] vis = new boolean[R][C];
        // 路径最长为遍历所有的点
        List<Node> tmp = new ArrayList<Node>();
        // 出发点[0, 0]
        tmp.add(new Node(0, 0));
        vis[0][0] = true;
        dfs(A, vis, 0, 0, tmp);
        tmp.remove(tmp.size() - 1);
        vis[0][0] = false;
        return shortPath;
    }
}