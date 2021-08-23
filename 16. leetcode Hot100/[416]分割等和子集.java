//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 动态规划 
// 👍 785 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        final int N = nums==null?0:nums.length;
        if (N <= 0) {
            return true;
        }

        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        if ((sum & 0x01) == 1) {
            return false;
        }

        int V = sum >> 1;

        boolean[] dp = new boolean[V + 1];
        dp[0] = true;
        for (int x : nums) {
            for (int node = V; node -x >= 0; node--) {
                int newNode = node;
                int oldNode = node-x;
                if (dp[oldNode]) {
                    dp[newNode] = true;
                }
            }
        }
        return dp[V];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
