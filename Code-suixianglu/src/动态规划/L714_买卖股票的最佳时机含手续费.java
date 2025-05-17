package 动态规划;

public class L714_买卖股票的最佳时机含手续费 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int has = - prices[0] - fee;
            int sell = 0;
            for (int i = 1; i <= prices.length - 1; i++) {
                int newHas = Integer.max(has, sell - prices[i] - fee);
                int newSell = Integer.max(has + prices[i], sell);
                has = newHas;
                sell = newSell;
            }
            return Integer.max(has, sell);
        }
    }
}
