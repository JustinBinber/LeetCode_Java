package 贪心;

/**
 * @author: yangjiabin
 * @date: 2025/5/7 10:52
 * @desc:
 */
public class L122_买卖股票的最佳时机II {
    class Solution {
        public int maxProfit(int[] prices) {
            int[] dif = new int[prices.length - 1];
            int ans = 0;
            for (int i = 0; i <= dif.length - 1; i++) {
                dif[i] = prices[i + 1] - prices[i];
                if (dif[i] > 0) ans += dif[i];
            }
            return ans;
        }
    }
}
