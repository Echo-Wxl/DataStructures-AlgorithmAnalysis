//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 575 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void backTrace(int[] nums, int i, List<Integer> box, List<List<Integer>> ans) {
        final int N = nums==null ?0:nums.length;

        ans.add(new ArrayList<>());
        for (Integer x : box) {
            ans.get(ans.size()-1).add(x);
        }
        if (i >= N) {
            return;
        }
//        for (int j = i; j < N; j++) {
//            if (j > i && nums[j] == nums[j - 1]) {
//                continue;
//            }
//            box.add(nums[j]);
//            backTrace(nums, j+1, box, ans);
//            box.remove(box.size()-1);
//        }
        Set<Integer> S = new HashSet<>();
        for (int j = i; j < N; j++) {
            if (!S.contains(nums[j])) {
                box.add(nums[j]);
                backTrace(nums, j+1, box, ans);
                box.remove(box.size()-1);
                S.add(nums[j]);
            }
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> box = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backTrace(nums, 0, box, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
