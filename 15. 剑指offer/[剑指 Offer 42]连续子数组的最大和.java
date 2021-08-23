//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 数组 分治 动态规划 
// 👍 291 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int N = nums.length;

        int tmp = 0;
        int ans = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int x : nums) {
            tmp = Math.max(tmp, 0)+x;
            ans = Math.max(tmp, ans);
            maxValue = Math.max(x, maxValue);
        }

        return maxValue<0?maxValue:ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
