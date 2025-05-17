package 动态规划;

public class L718_最长重复子数组 {
    class Solution_dp {
        public int findLength(int[] nums1, int[] nums2) {
            int[][] dp = new int[nums1.length][nums2.length];
            int ans = 0;
            for (int i = 0; i <= nums1.length - 1; i++) {
                for (int j = 0; j <= nums2.length - 1; j++) {
                    if (i == 0 || j == 0) dp[i][j] = nums1[i] == nums2[j] ? 1 : 0;
                    else if (nums1[i] == nums2[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                    else dp[i][j] = 0;
                    ans = Integer.max(ans, dp[i][j]);
                }
            }
            return ans;
        }
    }

}
