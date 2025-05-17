package 动态规划;

import java.util.Arrays;

public class L518_零钱兑换II {
        class Solution {
            public int change(int amount, int[] coins) {
                if (amount == 0) return 1;
                int[][] dp = new int[coins.length + 1][amount + 1];
                for (int i = 1; i <= coins.length; i++) {
                    for (int j = 1; j <= amount; j++) {
                        if (coins[i - 1] < j) {
                            dp[i][j] = Integer.max(dp[i - 1][j], dp[i - 1][j] + dp[i][j - coins[i - 1]]);
                        }
                        else if (coins[i - 1] == j) dp[i][j] = dp[i - 1][j] + 1;
                        else dp[i][j] = dp[i - 1][j];
                    }
                }
                System.out.println(Arrays.deepToString(dp));
                return dp[coins.length][amount];
            }
        }

    public static void main(String[] args) {
        L518_零钱兑换II l518_零钱兑换II = new L518_零钱兑换II();
        Solution solution = l518_零钱兑换II.new Solution();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
    }
}
