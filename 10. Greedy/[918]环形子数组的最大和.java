//给定一个由整数数组 nums 表示的环形数组 C，求 C 的非空子数组的最大可能和。
//
// 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < nums.length 时 C[i] = nums[i]，且当 i >= 0 时
//C[i+nums.length] = C[i]）
//
// 此外，子数组最多只能包含固定缓冲区 nums 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1,
//k2 <= j 其中 k1 % nums.length = k2 % nums.length）
//
// 
//
// 示例 1： 
//
// 输入：[1,-2,3,-2]
//输出：3
//解释：从子数组 [3] 得到最大和 3
// 
//
// 示例 2： 
//
// 输入：[5,-3,5]
//输出：10
//解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
// 
//
// 示例 3： 
//
// 输入：[3,-1,2,-1]
//输出：4
//解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
// 
//
// 示例 4： 
//
// 输入：[3,-2,2,-3]
//输出：3
//解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
// 
//
// 示例 5： 
//
// 输入：[-2,-3,-1]
//输出：-1
//解释：从子数组 [-1] 得到最大和 -1
// 
//
// 
//
// 提示： 
//
// 
// -30000 <= nums[i] <= 30000
// 1 <= nums.length <= 30000
// 
// Related Topics 数组 
// 👍 163 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Node {
        public int start = 0;
        public int end = 0;
        public long ans = 0;
        Node(int a, int b, long c) {
            start = a;
            end = b;
            ans = c;
        }
    }

    private Node getMinRange(int[] nums) {
        final int N = nums == null ? 0 : nums.length;

        long tmp = 0;
        int tmp_start = 0;
        int tmp_end = 0;

        long ans = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            if (tmp >= 0) {
                tmp_start = i;
                tmp = 0;
            }
            tmp += nums[i];
            tmp_end = i;
            if (tmp < ans) {
                ans = tmp;
                start = tmp_start;
                end = tmp_end;
            }
        }

        return new Node(start, end, ans);
    }

    private Node getMaxRange(int[] nums) {
        final int N = nums == null ? 0 : nums.length;
        long tmp = 0;
        int tmp_start = 0;
        int tmp_end = 0;

        long ans = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            if (tmp < 0) {
                tmp_start = i;
                tmp = 0;
            }
            tmp += nums[i];
            tmp_end = i;
            if (tmp > ans) {
                ans = tmp;
                start = tmp_start;
                end = tmp_end;
            }
        }

        return new Node(start, end, ans);
    }

    private int getMaxValue(int[] nums) {
        final int N = nums == null ? 0 : nums.length;

        int maxValue = Integer.MIN_VnumsLUE;
        for (int i = 0; i < N; i++) {
            maxValue = Math.max(nums[i], maxValue);
        }

        return maxValue;
    }

    public int maxSubarraySumCircular(int[] nums) {
        final int N = nums == null ? 0 : nums.length;

        if (N <= 0) {
            return 0;
        }

        int maxValue = getMaxValue(nums);
        if (maxValue < 0) {
            return maxValue;
        }

        long s = 0;
        for (int x: nums) {
            s += x;
        }

        Node small = getMinRange(nums);
        Node large = getMaxRange(nums);

        if (s - small.ans > large.ans) {
            return (int)(s - small.ans);
        }
        return (int)large.ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
