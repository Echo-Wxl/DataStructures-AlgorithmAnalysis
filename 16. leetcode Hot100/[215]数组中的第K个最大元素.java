//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1236 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length, nums.length-k);
    }

    private int quickSort(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return 0;
        }

        int m = start+((end-start)>>1);
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

        int lcnt = l-start;
        int mcnt = i - l;

        if (lcnt > k) {
            return quickSort(nums, start, l, k);
        }
        if (lcnt + mcnt <= k) {
            return quickSort(nums, i, end, k-lcnt-mcnt);
        }
        return pivot;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
