/*
给定一个迷宫，其中 0 表示可能通过的地方，而 1 表示墙壁。请问，从左上角走到右下角的最短路径是什么样的？请依次输出行走的点坐标。

输入：A = [[0, 1], [0, 0]]
输出：ans = [[0, 0], [1, 0], [1,1]]
 */

class Node {
    public int r;
    public int c;
    public Node(){}

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}


class Solution {
    private List<Node> shortPath = null;
    private int R, C;
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private List<Node> Clone(List<Node> tmp) {
        List<Node> ans = new ArrayList<Node>();
        for (int i = 0; i < tmp.size(); i++) {
            Node x = tmp.get(i);
            ans.add(new Node(x.r, x,r));
        }
    }

    private void dfs(int[][] A, boolean[][] vis, int r, int c, List<Node> tmp) {
        if (r = R - 1 && c = C - 1) {
            if (shortPath == null || shortPath.size() > tmp.size()) {
                shortPath = Clone(tmp);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            final int nr = r + dir[i][0];
            final int nc = c + dir[i][1];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }
            if (A[r][c] == 1 || vis[r][c] == true) {
                continue;
            }

            vis[nr][nc] = true;
            tmp.add(new Node(nr, nc));
            dfs(A, vis, nr, nc, tmp);
            tmp.remove(tmp.size()-1);
            vis[nr][nc] = false;
        }
    }

    public List<Node> findMinPath(int[][] A) {
        if (A == null || A.length == 0) {
            return new ArrayList<>();
        }

        R = A.length;
        C = A[0].length;

        boolean[][] vis = new boolean[R][C];

        List<Node> tmp = new ArrayList<>();

        tmp.add(new Node(0, 0));
        vis[0][0] = true;
        dfs(A, vis, 0, 0, tmp);
        tmp.remove(tmp.size()-1);
        vis[0][0] = false;
        return shortPath;
    }
}