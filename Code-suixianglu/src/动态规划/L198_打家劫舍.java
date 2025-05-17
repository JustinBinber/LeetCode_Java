package 动态规划;

public class L198_打家劫舍 {
    class Solution_old {
        public int rob(int[] nums) {
            int[] dp = new int[nums.length];
            if (nums == null) return 0;
            if (nums.length == 1) return nums[0];
            if (nums.length == 2) {
                return Integer.max(nums[0], nums[1]);
            }

            for (int i = 0; i <= nums.length - 1; i++) {
                if (i == 0) dp[0] = nums[0];
                else if (i == 1) dp[1] = Integer.max(nums[0], nums[1]);
                else {
                    dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);
                }
            }
            return dp[nums.length - 1];
        }
    }

}
