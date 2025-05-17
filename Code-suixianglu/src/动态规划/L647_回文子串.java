package 动态规划;

public class L647_回文子串 {
    class Solution {
        public int countSubstrings(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            int ans = 0;
            for (int i = s.length() - 1; i >= 0; i--){
                for (int j = i; j <= s.length() - 1; j++){
                    if (j == i) dp[i][j] = true;
                    else if (s.charAt(i) != s.charAt(j)) dp[i][j] = false;
                    else{
                        if (j - i == 1) dp[i][j] = true;
                        else dp[i][j] = dp[i + 1][j - 1];
                    }
                    ans = dp[i][j] ? ans + 1 : ans;
                }
            }
            return ans;
        }
    }
}
