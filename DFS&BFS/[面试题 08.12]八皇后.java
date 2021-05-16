//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
//个棋盘的那两条对角线。 
//
// 注意：本题相对原题做了扩展 
//
// 示例: 
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 回溯算法 
// 👍 85 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean[] row = null;
    private boolean[] left = null;
    private boolean[] right = null;

    // A是棋盘
    private char[][] A = null;

    private List<List<String>> ans = null;

    private void Init(int n) {
        // 初始化：row, left, right; 编程点矩阵
        row = new boolean[n];
        left = new boolean[n + n];
        right = new boolean[n + n];

        A = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(A[i], '.');
        }
        ans = new ArrayList<>();
    }

    private void Clone() {
        // A复制给ans
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            tmp.add(new String(A[i]));
        }
        ans.add(tmp);
    }

    private void dfs(int c, int C) {
        // c>=C, clone和退出
        if (c >= C) {
            Clone();
            return;
        }
        // 遍历C，判断，回溯
        for (int i = 0; i < C; i++) {
            if (row[i] || left[i + c] || right[i + C - c]) {
                continue;
            }

            row[i] = left[i+c] = right[i+C-c] = true;
            A[i][c] = 'Q';
            dfs(c+1, C);
            row[i] = left[i+c] = right[i+C-c] = false;
            A[i][c] = '.';
        }

    }
    public List<List<String>> solveNQueens(int n) {
        Init(n);
        dfs(0, n);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
