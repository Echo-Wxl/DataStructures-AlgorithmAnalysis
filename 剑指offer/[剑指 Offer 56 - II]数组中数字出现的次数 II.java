//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 
// 👍 194 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private int threeSplit(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int m = start + ((end-start)>>1);
        int pivot = nums[m];

        int l = start, i = start, r = end-1;
        while (i <= r) {
            if (nums[i] < pivot) {
                swap(nums, i++, l++);
            } else if (nums[i] == pivot) {
                i++;
            } else {
                swap(nums, i, r--);
            }
        }
        if ((i - l) == 1) {
            return nums[l];
        }
        if ((l - start) % 3 == 1) {
            return threeSplit(nums, start, l);
        }
        return threeSplit(nums, i, end);
    }
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return threeSplit(nums, 0, nums.length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
