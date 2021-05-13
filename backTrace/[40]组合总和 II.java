//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 573 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void backTrace(int[] A, int target, int start, int boxSum, List<Integer> box, List<List<Integer>> ans) {
        final int N = A==null ?0:A.length;

        if (boxSum == target) {
            ans.add(new ArrayList<>());
            for (Integer x : box) {
                ans.get(ans.size()-1).add(x);
            }
        }

        if (boxSum >= target || start >= N) {
            return;
        }

        for (int i = start; i < N; i++) {
            if (i > start && A[i] == A[i - 1]) {
                continue;
            }
            box.add(A[i]);
            boxSum += A[i];
            backTrace(A, target, i+1, boxSum, box, ans);
            box.remove(box.size()-1);
            boxSum -= A[i];
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> box = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int boxSum = 0;
        Arrays.sort(candidates);
        backTrace(candidates, target, 0, boxSum, box, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
