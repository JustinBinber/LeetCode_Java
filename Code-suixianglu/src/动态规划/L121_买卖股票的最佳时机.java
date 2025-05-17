package 动态规划;

public class L121_买卖股票的最佳时机 {
    class Solution {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE;
            int ans = 0;
            for (int i = 0; i <= prices.length - 1; i++) {
                min = Integer.min(min, prices[i]);
                ans = Integer.max(prices[i] - min, ans);
            }
            return ans;
        }
    }
}
