package 动态规划;

public class L674_最长连续递增序列 {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int ans = 1;
            int tem = 1;
            for (int i = 1; i <= nums.length - 1; i++) {
                if (nums[i] > nums[i - 1]) tem++;
                else tem = 1;
                ans = Integer.max(ans, tem);
            }
            return ans;
        }
    }
}
