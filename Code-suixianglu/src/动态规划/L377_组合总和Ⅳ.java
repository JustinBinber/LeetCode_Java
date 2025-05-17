package 动态规划;

import java.util.Arrays;

/**
 * @author: yangjiabin
 * @date: 2025/5/11 09:40
 * @desc:
 */
public class L377_组合总和Ⅳ {
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int n = nums.length;
            int[][] dp = new int[n + 1][target + 1];
            for (int i = 0; i < n + 1; i++) {
                dp[i][0] = 1;
            }
            for (int j = 1; j < target + 1; j++) {
                for (int i = 1; i < n + 1; i++) {
                    if (j < nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[n][j - nums[i - 1]];
                    }
                }
            }
            System.out.println(Arrays.deepToString(dp));
            return dp[n][target];
        }
    }

    public static void main(String[] args) {
        L377_组合总和Ⅳ l377_组合总和Ⅳ = new L377_组合总和Ⅳ();
        Solution solution = l377_组合总和Ⅳ.new Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
