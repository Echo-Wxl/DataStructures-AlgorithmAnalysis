//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
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
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 
// 👍 341 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int R;
    private int C;
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean dfs(char[][] board, int r, int c, char[] word, int i) {
        if (r >= R || r < 0 || c >= C || c < 0 || board[r][c] != word[i]) {
            return false;
        }
        if (i == word.length - 1) {
            return true;
        }
        board[r][c] = '\0';
        for (int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if (dfs(board, nr, nc, word, i + 1)) {
                return true;
            }
        }
        board[r][c] = word[i];
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null) {
            return false;
        }
        R = board.length;
        C = board[0].length;

        char[] words = word.toCharArray();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (dfs(board, r, c, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
