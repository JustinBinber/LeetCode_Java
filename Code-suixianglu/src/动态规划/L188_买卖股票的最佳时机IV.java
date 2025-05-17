package 动态规划;

public class L188_买卖股票的最佳时机IV {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int[] buys = new int[k];
            int[] sells = new int[k];
            int ans = 0;
            for (int i = 0; i <= buys.length - 1; i++) {
                buys[i] = -prices[0];
            }

            for (int i = 1; i <= prices.length - 1; i++) {
                buys[0] = Integer.max(buys[0], -prices[i]);
                sells[0] = Integer.max(sells[0], prices[i] + buys[0]);
                for (int j = 1; j <= k - 1; j++) {
                    buys[j] = Integer.max(buys[j], sells[j - 1] - prices[i]);
                    sells[j] = Integer.max(sells[j], prices[i] + buys[j]);
                }
            }

            for (int i = 0; i <= sells.length - 1; i++) {
                ans = Integer.max(ans, sells[i]);
            }
            //System.out.println(buys);
            return ans;
        }
    }
}
