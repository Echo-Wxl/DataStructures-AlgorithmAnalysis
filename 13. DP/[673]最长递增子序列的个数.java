//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 动态规划 
// 👍 308 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        final int N = nums==null ? 0:nums.length;
        if (N <= 0) {
            return 0;
        }
        int[] dp = new int[N + 1];
        int[] count = new int[N + 1];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxLength = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i]++;
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] == maxLength) {
                ans += count[i];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
