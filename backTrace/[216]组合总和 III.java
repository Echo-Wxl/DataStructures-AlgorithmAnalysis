//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 303 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void backTrace(int begin, int end, int k, List<Integer> box, List<List<Integer>> ans) {
        if (box.size() == k && box.stream().reduce(Integer::sum).orElse(0)==end-1) {
            ans.add(new ArrayList<>());
            for (Integer x : box) {
                ans.get(ans.size()-1).add(x);
            }
        }

        if (begin >= end || box.stream().reduce(Integer::sum).orElse(0)>end-1|| box.size() > k) {
            return;
        }

        Set<Integer> S = new HashSet<>();
        for (int i = begin; i < end; i++) {
            if (!S.contains(i % 10)) {
                box.add(i%10);
                backTrace(i+1, end, k, box, ans);
                box.remove(box.size()-1);
                S.add(i%10);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> box = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backTrace(1, n+1, k, box, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
