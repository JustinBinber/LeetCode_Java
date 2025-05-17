package 动态规划;

public class L213_打家劫舍II {
    class Solution {
        public int rob(int[] nums) {
            int[] dp = new int[nums.length];
            if (nums.length <= 3) {
                int ans = Integer.MIN_VALUE;
                for (int i = 0; i <= nums.length - 1; i++) {
                    ans = Integer.max(ans, nums[i]);
                }
                return ans;
            }
            return Integer.max(robAction(nums, 0, nums.length - 2), robAction(nums, 1, nums.length - 1));

        }
        public int robAction(int[] nums, int left, int right){
            int[] dp = new int[right - left + 1];
            dp[0] = nums[left];
            dp[1] = Integer.max(nums[left], nums[left + 1]);
            for (int i = left + 2; i <= right; i++) {
                dp[i - left] = Integer.max(nums[i] + dp[i - left - 2], dp[i - 1]);
            }
            //System.out.println(Arrays.toString(dp));
            return dp[dp.length - 1];
        }
    }
}
