package 动态规划;

import java.util.Arrays;

/**
 * @author: yangjiabin
 * @date: 2025/5/10 10:31
 * @desc:
 */
public class L416_分割等和子集 {
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int i = 0; i <= nums.length - 1; i++) {
                sum += nums[i];
            }
            if (sum % 2 != 0) return false;
            int target = sum / 2;

            int[][] danamic = new int[target + 1][nums.length];
            for (int i = 0; i < target + 1; i++) {
                if (i >= nums[0]) danamic[i][0] = nums[0];
            }

            for (int i = 1; i <= target; i++) {
                for (int j = 1; j <= nums.length - 1; j++) {
                    if (i >= nums[j]) danamic[i][j] = Integer.max(danamic[i][j - 1], danamic[i - nums[j]][j - 1] + nums[j]);
                    else danamic[i][j] = danamic[i][j - 1];
                }
            }
            if (danamic[target][nums.length - 1] == target) return true;
            return false;

        }
    }

    public static void main(String[] args) {
        L416_分割等和子集 l416_分割等和子集 = new L416_分割等和子集();
        Solution solution = l416_分割等和子集.new Solution();
        System.out.println(solution.canPartition(new int[]{1, 2, 5}));
    }
}
