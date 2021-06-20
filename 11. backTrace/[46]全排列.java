//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 回溯算法 
// 👍 1339 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void swap(int[] box, int i, int j) {
        int tmp = box[i];
        box[i] = box[j];
        box[j] = tmp;
    }
    private void backTrace(int[] box, int i, List<List<Integer>> ans) {
        final int N = box==null ? 0:box.length;
        if (i == N) {
            ans.add(new ArrayList<>());
            for (int x : box) {
                ans.get(ans.size()-1).add(x);
            }
        }
        if (i >= N) {
            return;
        }
        for (int j = i; j < N; j++) {
            swap(box, i, j);
            backTrace(box, i+1,  ans);
            swap(box, i, j);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        final int N = nums==null ? 0:nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        backTrace(nums, 0,  ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
