//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1337 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void backTrace(int[] candidates, int target, int i, int boxSum, List<Integer> box, List<List<Integer>> ans) {
        final int N = candidates==null ?0: candidates.length;
        if (boxSum == target) {
            ans.add(new ArrayList<>());
            for (Integer x : box) {
                ans.get(ans.size()-1).add(x);
            }
        }
        if (boxSum>= target || i >= N) {
            return;
        }

        for (int j = i; j < N; j++) {
            box.add(candidates[j]);
            boxSum += candidates[j];
            backTrace(candidates, target, j, boxSum, box, ans);
            box.remove(box.size()-1);
            boxSum -= candidates[j];
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> box = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int boxSum = 0;
        backTrace(candidates, target, 0, boxSum, box, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
