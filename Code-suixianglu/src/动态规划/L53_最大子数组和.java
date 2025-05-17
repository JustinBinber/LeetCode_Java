package 动态规划;

public class L53_最大子数组和 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length + 1];
            int ans = Integer.MIN_VALUE;
            for (int i = 1; i <= nums.length; i++) {
                if (dp[i - 1] <= 0) dp[i] = nums[i - 1];
                else dp[i] = dp[i - 1] + nums[i - 1];
                ans = Integer.max(dp[i], ans);
            }
            return ans;
        }
    }
}
