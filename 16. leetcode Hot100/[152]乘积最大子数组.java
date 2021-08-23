//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1239 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int N = nums.length;
        int maxF = nums[0], minF = nums[0], ans = nums[0];

        for (int i = 1; i < N; i++) {
            int max = maxF, min = minF;
            maxF = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            minF = Math.min(min * nums[i], Math.min(max * nums[i], nums[i]));
            ans = Math.max(ans, maxF);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
