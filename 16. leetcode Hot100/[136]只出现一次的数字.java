//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1828 👎 0


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

        int l = first, i =first, r = end-1;

        while (i <= r) {
            if (arr[i] < pivot) {
                swap(arr, i++,l++);
            } else if (arr[i] == pivot) {
                i++;
            } else {
                swap(arr, i, r--);
            }
        }

        if ((i - l) == 1) {
            return arr[l];
        }

        if ((l - first) % 2 == 1) {
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
