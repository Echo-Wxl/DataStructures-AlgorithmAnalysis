class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        final int len1 = text1.length();
        final int len2 = text2.length();

        int[][] dp = new int[len1][len2];

        int ans = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i-1][j-1]+1;
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
    }
    return ans;
}