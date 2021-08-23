//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 
// 👍 271 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int R = matrix.length;
        int C = matrix[0].length;

        boolean[][] vis = new boolean[R][C];
        int total = R*C;
        int[] ans = new int[total];
        int r = 0, c = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0;
        for (int i = 0; i < total; i++) {
            ans[i] = matrix[r][c];
            vis[r][c] = true;
            int nr = r + dir[dirIndex][0], nc = c+dir[dirIndex][1];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C||vis[nr][nc]) {
                dirIndex = (dirIndex+1)%4;
            }
            r += dir[dirIndex][0];
            c += dir[dirIndex][1];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
