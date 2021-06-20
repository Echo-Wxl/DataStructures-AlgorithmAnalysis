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
// 👍 317 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> box = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    private void backTrace(int n, int k, int i, int sum) {
        if (box.size() + (n - i + 1) < k || box.size() > k) {
            return;
        }
        if (box.size() == k) {
            int boxSum = 0;
            for (int num : box) {
                boxSum += num;
            }
            if (boxSum == sum) {
                ans.add(new ArrayList<>(box));
                return;
            }
        }
        box.add(i);
        backTrace(n, k, i+1, sum);
        box.remove(box.size()-1);
        backTrace(n, k, i+1, sum);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int boxSum = 0;
        backTrace(9, k, 1, n);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
