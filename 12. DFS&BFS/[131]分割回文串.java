//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 720 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void Clone(List<String> box, List<List<String>> ans) {
        ans.add(new ArrayList<>());
        for (String str : box) {
            ans.get(ans.size()-1).add(str);
        }
    }

    private void backTrace(String s, boolean[][] dp, int start, List<String> box, List<List<String>> ans) {
        if (start == s.length()) {
            Clone(box, ans);
            return;
        }

        for (int cut = start; cut < s.length(); cut++) {
            if (dp[start][cut]) {
                String word = s.substring(start, cut+1);
                box.add(word);
                backTrace(s, dp, cut+1, box, ans);
                box.remove(box.size()-1);
            }

        }
    }

    // 重点是初始化dp， 其他和回溯算法一样
    private void build(String s, boolean[][] dp) {
        final int N = s.length();

        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i +1 < N; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
        }

        for (int len = 2; len < N; len++) {
            for (int i = 0; i < N - len; i++) {
                final int j = i+len;
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return ans;
        }

        final int N = s.length();
        boolean[][] dp = new boolean[N][N];

        build(s, dp);

        List<String> box = new ArrayList<>();

        backTrace(s, dp, 0, box, ans);

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
