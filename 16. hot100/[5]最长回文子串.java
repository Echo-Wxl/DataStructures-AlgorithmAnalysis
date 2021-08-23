//给你一个字符串 s，找到 s 中最长的回文子串。 
//
//
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3944 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String orign = s;
        String reverse = new StringBuffer(orign).reverse().toString();

        int N = s.length();
        int[][] dp = new int[N][N];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (orign.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }

                if (dp[i][j] > maxLen) {
                    int beforePos = N-1-j;
                    if (beforePos + dp[i][j] - 1 == i) {
                        maxLen = dp[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd-maxLen+1, maxEnd+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
