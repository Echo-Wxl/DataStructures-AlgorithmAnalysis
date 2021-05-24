//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划 
// 👍 449 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        final int N = nums1.length;
        final int M = nums2.length;

        if (N == 0 || M == 0) {
            return 0;
        }
        int[][] dp = new int[N + 1][M + 1];
        int ans = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                dp[i][j] = nums1[i]==nums2[j]? dp[i+1][j+1]+1:0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
