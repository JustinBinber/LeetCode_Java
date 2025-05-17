package 动态规划;

import java.util.List;

public class L139_单词拆分 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 0; i <= wordDict.size() - 1; i++) {
                for (int j = 1; j <= s.length(); j++) {
                    if (wordDict.get(i).length() <= j && s.substring(j - wordDict.get(i).length(), j).equals(wordDict.get(i))){
                        dp[j] = dp[j] || dp[j - wordDict.get(i).length()];
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
