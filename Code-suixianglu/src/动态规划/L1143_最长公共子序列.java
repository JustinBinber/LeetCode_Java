package 动态规划;

public class L1143_最长公共子序列 {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length()][text2.length()];
            for (int i = 0; i <= text1.length() - 1; i++) {
                for (int j = 0; j <= text2.length() - 1; j++) {
                    boolean equal = text1.charAt(i) == text2.charAt(j);
                    if (i == 0) {
                        if (equal) dp[i][j] = 1;
                        else if (j >= 1) dp[i][j] = dp[i][j - 1];
                    } else if (j == 0) {
                        if (equal) dp[i][j] = 1;
                        else dp[i][j] = dp[i - 1][j];
                    }
                    else {
                        if (equal) dp[i][j] = dp[i - 1][j - 1]+ 1;
                        else dp[i][j] = Integer.max(dp[i][j - 1], dp[i - 1][j]);
                    }

                }
            }
            //System.out.println(Arrays.deepToString(dp));
            return dp[text1.length() - 1][text2.length() - 1];
        }
    }
}
