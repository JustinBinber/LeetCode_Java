package 动态规划;

public class L300_最长递增子序列 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int max = 1;
            for (int i = 0; i <= nums.length - 1; i++) {
                dp[i] = 1;
            }

            for (int i = 0; i <= dp.length - 1; i++) {
                for (int j = 0; j <= i - 1; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Integer.max(dp[j] + 1, dp[i]);
                        max = Integer.max(dp[i], max);
                    }
                }
            }
            return max;
        }
    }
}
