//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 
// 👍 283 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Deque<Integer> Q = new ArrayDeque<>();

    private void push(int val) {
        while (!Q.isEmpty() && Q.getLast() < val) {
            Q.removeLast();
        }
        Q.addLast(val);
    }

    private void pop(int val) {
        if (!Q.isEmpty() && Q.getFirst() == val) {
            Q.removeFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            push(nums[i]);
            if (i < k - 1) {
                continue;
            }
            ans.add(Q.getFirst());
            pop(nums[i - k + 1]);
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
