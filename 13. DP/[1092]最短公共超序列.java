//给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。 
//
// （如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列） 
//
// 
//
// 示例： 
//
// 输入：str1 = "abac", str2 = "cab"
//输出："cabac"
//解释：
//str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。 
//str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
//最终我们给出的答案是满足上述属性的最短字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= str1.length, str2.length <= 1000 
// str1 和 str2 都由小写英文字母组成。 
// 
// Related Topics 动态规划 
// 👍 66 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        final int N = str1.length();
        final int M = str2.length();
        if (N == 0 && M != 0) {
            return str2;
        }
        if (M == 0 && N != 0) {
            return str1;
        }

        String[][] dp = new String[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.indexOf(i);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }

        String ans = dp[N][M];
        int j=0, k = 0;
        for (int i = 0; i < ans.length(); i++) {
            while (j < N && str1.indexOf(j) != ans.indexOf(i)) {
                ans += str1.indexOf(j++);
            }
            while (k < M && str2.indexOf(k) != ans.indexOf(i)) {
                ans+= str2.indexOf(k++);
            }
        }
        return ans+str1.substring(j, N)+str2.substring(k, M);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
