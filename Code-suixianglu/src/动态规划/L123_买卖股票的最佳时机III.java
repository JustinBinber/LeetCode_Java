package 动态规划;

public class L123_买卖股票的最佳时机III {
    class Solution {
        public int maxProfit(int[] prices) {
            int buy1 = -prices[0], sell1 = 0, buy2 = -prices[0], sell2 = 0;
            for (int i = 1; i <= prices.length - 1; i++) {
                buy1 = Integer.max(buy1, -prices[i]);
                sell1 = Integer.max(sell1, prices[i] + buy1);
                buy2 = Integer.max(buy2, sell1 - prices[i]);
                sell2 = Integer.max(sell2, buy2 + prices[i]);

            }
            return Integer.max(Integer.max(sell1, sell2), 0);
        }
    }
}
