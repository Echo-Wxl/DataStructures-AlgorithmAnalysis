//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 数组 哈希表 分治 计数 排序 
// 👍 167 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        final int N = nums.length;
        int mid = N/2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count+1);
            if (count+1 > mid) {
                return nums[i];
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
