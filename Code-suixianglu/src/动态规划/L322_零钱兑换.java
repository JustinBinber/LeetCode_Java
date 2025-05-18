package 动态规划;

import 回溯.L332_重新安排行程;

import java.util.Arrays;

/**
 * @author: yangjiabin
 * @date: 2025/5/12 09:47
 * @desc:
 */
public class L322_零钱兑换 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                dp[i] = i % coins[0] == 0 ? i / coins[0] : 1200;
            }
            //System.out.println(Arrays.toString(dp));
            for (int i = 1; i <= coins.length - 1; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j >= coins[i]) dp[j] = Integer.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
            //System.out.println(Arrays.toString(dp));

            return dp[amount] == 1200 ? -1 : dp[amount];
         }
    }

    public static void main(String[] args) {
        L322_零钱兑换 l322_零钱兑换 = new L322_零钱兑换();
        Solution solution = l322_零钱兑换.new Solution();
        System.out.println(solution.coinChange(new int[]{2, 5, 10, 1}, 27));
    }
}
