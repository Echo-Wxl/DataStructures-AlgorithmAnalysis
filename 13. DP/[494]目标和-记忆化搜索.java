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
// -1000 <= target <= 1000 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 811 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    private int dp(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        String key = i+","+sum;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int result = dp(nums, i + 1, sum + nums[i], target) + dp(nums, i + 1, sum - nums[i], target);
        map.put(key, result);
        return result;
    }
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return dp(nums, 0, 0 , target);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
