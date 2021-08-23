//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 
// 👍 450 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int cnt;
    private void msort(int[] nums, int start, int end, int[] tmp) {
        if (start >= end || start + 1 == end) {
            return;
        }
        final int m = start+((end-start)>>1);
        msort(nums, start, m, tmp);
        msort(nums, m, end, tmp);

        int i = start, j = m, k = start;
        while (i < m || j < end) {
            if (j >= end || (i < m && nums[i] <= nums[j])) {
                tmp[k++] = nums[i++];
                cnt += j - m;
            } else {
                tmp[k++] = nums[j++];
            }
        }

        for (int l = start; l < end; l++) {
            nums[l] = tmp[l];
        }
    }
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tmp = new int[nums.length];
        cnt = 0;
        msort(nums, 0, nums.length, tmp);
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
