//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 580 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void backTrace(int begin, int end, int k, List<Integer> box, List<List<Integer>> ans) {
        if (box.size() == k) {
            ans.add(new ArrayList<>());
            for (Integer x : box) {
                ans.get(ans.size()-1).add(x);
            }
        }

        if (begin >= end || box.size() > k) {
            return;
        }

        for (int i = begin; i < end; i++) {
            box.add(i);
            backTrace(i+1, end, k, box, ans);
            box.remove(box.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> box = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backTrace(1, n+1, k, box, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
