//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 
// 👍 996 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int R;
    int C;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean dfs(char[][] board, boolean[][] VIS, String word, int r, int c, int k) {
        if (word.charAt(k) != board[r][c]) {
            return false;
        } else if(k == word.length()-1){
            return true;
        }

        VIS[r][c] = true;
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if (!(nr < 0 || nr >= R || nc < 0 || nc >= C)) {
                if (!VIS[nr][nc]) {
                    boolean flag = dfs(board, VIS, word, nr, nc, k+1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        VIS[r][c] = false;
        return result;
    }


    public boolean exist(char[][] board, String word) {
        R = board.length;
        C = board[0].length;

        boolean[][] VIS = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                boolean ans = dfs(board, VIS, word, r, c, 0);
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
