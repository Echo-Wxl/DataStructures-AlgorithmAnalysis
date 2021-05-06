//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 627 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 是否存在长度为len的子数组和和>=target
     *      0：存在
     *      -1：不存在
     * @param arr
     * @param len
     * @param target
     * @return
     */
    private int getC(int[] arr, int len, int target) {
        int sum = 0;
        final int N = arr == null ? 0:arr.length;
        // 滑动一个固定长度为len的窗口，并求出窗口的和
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (i < len - 1) {
                continue;
            }
            if (sum >= target) {
                return 0;
            }
            sum -= arr[i - (len - 1)];
        }
        return -1;
    }


    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int l = 1, r = nums.length + 1;
        while (l < r) {
            final int mid = l + ((r - l) >> 1);
            int mov = getC(nums, mid, target);
            if (mov < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l>nums.length ? 0:l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
