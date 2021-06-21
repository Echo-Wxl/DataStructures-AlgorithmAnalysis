//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。 
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//： 
//
// 
// 路径途经的所有单元格都的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索 
// 👍 100 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir={
                {0, 1}  /*右*/,
                {0, -1} /*左*/,
                {1, 0}  /*下*/,
                {-1, 0} /*上*/,
                {-1,-1} /*左上*/,
                {-1,1}  /*右上*/,
                {1,-1}  /*左下*/,
                {1,1}   /*右下*/,
        };

        final int R = grid.length;
        final int C = grid[0].length;

        // 为空，或只有一个格子
        if (R <= 1 || C <= 1) {
            return Math.min(R, C);
        }
        // 初始点或终点为1，返回-1
        if (grid[0][0] == 1 || grid[R - 1][C - 1] == 1) {
            return -1;
        }

        Queue<int[]> Q = new LinkedList<>();
        int[] cur = new int[2];
        Q.add(cur);
        grid[cur[0]][cur[1]] = 1;

        int ans = 0;
        while (!Q.isEmpty()) {
            ans++;
            int qSize = Q.size();
            while (qSize-- > 0) {
                cur = Q.remove();
                if (cur[0] == R - 1 && cur[1] == C - 1) {
                    return ans;
                }
                for (int i = 0; i < 8; i++) {
                    int nr = cur[0] + dir[i][0];
                    int nc = cur[1] + dir[i][1];
                    if (!(nr < 0 || nr >= R || nc < 0 || nc >= C)) {
                        if (grid[nr][nc] != 1) {
                            grid[nr][nc] = 1;
                            Q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
