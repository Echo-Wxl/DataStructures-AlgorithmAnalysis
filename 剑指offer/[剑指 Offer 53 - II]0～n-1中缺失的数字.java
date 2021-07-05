//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 位运算 数组 哈希表 数学 二分查找 
// 👍 151 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int getC(int[] nums, int m) {
        if (nums[m] == m) {
            return -1;
        } else {
            return 1;
        }
    }
    public int missingNumber(int[] nums) {
        int N = nums.length;
        int l = 0, r = N;
        while (l < r) {
            int m = l +((r-l)>>1);
            int mov = getC(nums, m);
            if (mov < 0) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        System.out.println(l);
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
