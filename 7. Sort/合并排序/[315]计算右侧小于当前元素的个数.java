//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num
//s[i] 的元素的数量。 
//
// 
//
// 示例： 
//
// 输入：nums = [5,2,6,1]
//输出：[2,1,1,0] 
//解释：
//5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 572 👎 0

/**
 * 思路：参考逆序对数目
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] ans = null;
    private int[] idx = null;
    private int[] temp = null;

    private void mergeSort(int[] arr, int first, int end, int[] idx) {
        if (first >= end || first + 1 == end) {
            return;
        }
        final int middle = first + ((end - first) >> 1);
        mergeSort(arr, first, middle, idx);
        mergeSort(arr, middle, end, idx);

        int i = first;
        int j = middle;
        int k = first;

        while (i < middle || j < end) {
            if (j >= end || i < middle && arr[idx[i]] <= arr[idx[j]]) {
                ans[idx[i]] += j - middle;
                temp[k++] = idx[i++];
            } else {
                temp[k++] = idx[j++];
            }
        }
        for (int l = first; l < end; l++) {
            idx[l] = temp[l];
        }
    }


    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        final int n = nums.length;

        temp = new int[n];
        ans = new int[n];
        idx = new int[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        mergeSort(nums, 0, n, idx);
        return Arrays.stream(ans).boxed().collect(Collectors.toList());

    }
}
//leetcode submit region end(Prohibit modification and deletion)
