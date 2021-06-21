//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X"
//,"X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 536 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private char VIS = 'A';
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int R, C;

    private void dfs(char[][] A, int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }
            if (A[nr][nc] == 'O') {
                A[nr][nc] = VIS;
                dfs(A, nr, nc);
            }

        }
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        R = board.length;
        C = board[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (r == 0 || r == R - 1 || c == 0 || c == C - 1) {
                    if (board[r][c] == 'O') {
                        board[r][c] = VIS;
                        dfs(board, r,c);
                    }
                }
            }
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == VIS) {
                    board[r][c] = 'O';
                } else {
                    board[r][c] = 'X';
                }

            }

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
