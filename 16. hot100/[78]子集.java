//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1165 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void backTrace(int[] nums, int i, List<Integer> box, List<List<Integer>> ans) {
        final int N = nums == null ?0:nums.length;
        // 满足什么状态是我们需要的
        ans.add(new ArrayList<>());
        for (Integer x : box) {
            ans.get(ans.size()-1).add(x);
        }
        if (i >= N) {
            return;
        }

        for (int j = i; j < N; j++) {
            box.add(nums[j]);
            backTrace(nums, j+1, box, ans);
            box.remove(box.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> box = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backTrace(nums, 0, box, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
