package 动态规划;

public class L494_目标和 {
    /**
     * 只挑一些数出来，取其负值 当负值为tar = (sum - target) / 2算一次成功
     */
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int i = 0; i <= nums.length - 1; i++) {
                sum += nums[i];
            }
            int count = 0;
            if (sum == target || sum == -target){

                for (int i = 0; i <= nums.length - 1; i++) {
                    if (nums[i] == 0) count++;
                }
                return (int)Math.pow(2, count);
            }
            int tar = (sum - target) / 2;
            if ((sum - target) % 2 != 0 || tar < 0) return 0;

            int[][] dp = new int[nums.length + 1][tar + 1];
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= tar; j++) {
                    if (nums[i - 1] == j) dp[i][j] = dp[i - 1][j] + 1;
                    else if (nums[i - 1] == 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    else {
                        if (j - nums[i - 1] >= 0) dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                        else dp[i][j] = dp[i - 1][j];
                    }
                }
                if (nums[i - 1] == 0) count++;

            }
            return dp[nums.length][tar] * (int)Math.pow(2, count);
        }
    }

    public static void main(String[] args) {
        L494_目标和 l494_目标和 = new L494_目标和();
        Solution solution = l494_目标和.new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{9,7,0,3,9,8,6,5,7,6}, 2));
    }
}
