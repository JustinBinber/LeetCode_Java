package 动态规划;

public class L516_最长回文子序列 {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int[][] dp = new int[s.length()][s.length()];
            int ans = 0;
            for (int i = s.length() - 1; i >= 0 ; i--) {
                for (int j = i; j <= s.length() - 1 ; j++) {
                    if (j == i) dp[i][j] = 1;
                    else if (s.charAt(i) != s.charAt(j)) dp[i][j] = dp[i + 1][j - 1];
                    else {
                        if (j - 1 == 1) dp[i][j] = 2;
                        else dp[i][j] = Integer.min(dp[i][j - 1], dp[i + 1][j]) + 2;
                    }
                }
            }
            return dp[0][s.length() - 1];
        }
    }
}
