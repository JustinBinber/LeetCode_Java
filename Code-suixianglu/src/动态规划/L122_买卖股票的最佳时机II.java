package 动态规划;

public class L122_买卖股票的最佳时机II {
    class Solution {
        public int maxProfit(int[] prices) {
            int[] dp = new int[prices.length];
            dp[0] = 0;
            for (int i = 1; i <= dp.length - 1; i++) {
                if (prices[i] - prices[i - 1] > 0) dp[i] = dp[i - 1] + prices[i] - prices[i - 1];
                else dp[i] = dp[i - 1];
            }
            return dp[dp.length - 1];
        }
    }
}
