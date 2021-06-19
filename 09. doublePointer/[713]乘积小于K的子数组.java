//给定一个正整数数组 nums。 
//
// 找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 说明: 
//
// 
// 0 < nums.length <= 50000 
// 0 < nums[i] < 1000 
// 0 <= k < 10^6 
// 
// Related Topics 数组 双指针 
// 👍 246 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        final int N = nums== null ? 0:nums.length;
        int left = -1;
        int ans = 0;
        int sum = 1;
        for (int i = 0; i < N; i++) {
            final int x = nums[i];
            sum *= x;
            if (left < i && sum >= k) {
                int old = nums[++left];
                sum /= old;
            }
            ans += i-left;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
