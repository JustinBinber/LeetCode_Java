package 动态规划;

import java.util.Arrays;

public class L115_不同的子序列 {
    class Solution_erwei {
        public int numDistinct(String s, String t) {
            int[][] dp = new int[t.length() + 1][s.length() + 1];
            for (int i = 0; i <= s.length(); i++) {
                dp[t.length()][i] = 1;
            }
            for (int i = t.length() - 1; i >= 0; i--) {
                for (int j = s.length() - 1; j >= 0; j--) {
                    boolean equal = t.charAt(i) == s.charAt(j);
                    if (equal) dp[i][j] = dp[i + 1][j + 1] + dp[i][j + 1];
                    else dp[i][j] = dp[i][j + 1];
                }
            }
            System.out.println(Arrays.deepToString(dp));
            return dp[0][0];
        }
    }

}
