//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 694 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void swap(int[] box, int i, int j) {
        int tmp = box[i];
        box[i] = box[j];
        box[j] = tmp;
    }

    private void backTrace(int[] box, int i, List<List<Integer>> ans) {
        final int N = box== null ?0:box.length;
        if (i == N) {
            ans.add(new ArrayList<>());
            for (int x : box) {
                ans.get(ans.size()-1).add(x);
            }
            return;
        }

        // 去重
        Set<Integer> s = new HashSet<>();
        for (int j = i; j < N; j++) {
            if (!s.contains(box[j])) {
                swap(box, i, j);
                backTrace(box, i+1, ans);
                swap(box, i, j);
                s.add(box[j]);
            }

        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        final int N = nums==null ?0:nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        backTrace(nums, 0,  ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
