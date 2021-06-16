//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -231 <= nums[i] <= 231 - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
// Related Topics 位运算 
// 👍 559 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int threeSpilt(int[] arr, int first, int end) {
        if (first >= end) {
            return 0;
        }

        int middle = first + ((end - first) >> 1);
        int pivot = arr[middle];

        int i = first;
        int l = first;
        int r = end - 1;

        while (i <= r) {
            if (arr[i] < pivot) {
                swap(arr, l++, i++);
            } else if (arr[i] == pivot) {
                i++;
            } else {
                swap(arr, i, r--);
            }
        }

        if ((i - l) == 1) {
            return arr[l];
        }

        if ((l - first) % 3 == 1) {
            return threeSpilt(arr, first, l);
        }
        return threeSpilt(arr, i, end);
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        return threeSpilt(nums, 0, nums.length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
