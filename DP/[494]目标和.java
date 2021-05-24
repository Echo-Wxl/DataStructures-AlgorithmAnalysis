//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 100 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 667 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        final int N = nums == null ? 0:nums.length;

        int total = 0;
        for (int x : nums) {
            total += x;
        }

        target = target>=0? target:-target;
        if (target > total) {
            return 0;
        }

        if (((target + total) & 0x01) == 1) {
            return 0;
        }

        int V = (target+total)>>1;

        int zero = 0;
        for (int x : nums) {
            zero += x == 0 ? 1 : 0;
        }

        int[] dp = new int[V + 1];
        dp[0] =1;

        for (int x : nums) {
            if (x != 0) {
                for (int sum = V; sum >=x ; sum--) {
                    int old = sum-x;
                    int newSum = sum;
                    dp[newSum] += dp[old];
                }
            }
        }
        return dp[V] * (1 << zero);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
