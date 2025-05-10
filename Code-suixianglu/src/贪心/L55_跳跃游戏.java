package 贪心;

import javax.management.MXBean;

/**
 * @author: yangjiabin
 * @date: 2025/5/7 11:08
 * @desc:
 */
public class L55_跳跃游戏 {
    class Solution {
        public boolean canJump(int[] nums) {
            int max = 0;
            for (int i = 0; i <= nums.length - 1; i++) {
                if (i > max) return false;
                max = Integer.max(max, i + nums[i]);
            }
            return true;
        }

    }

    public static void main(String[] args) {
        L55_跳跃游戏 l55_跳跃游戏 = new L55_跳跃游戏();
        Solution solution = l55_跳跃游戏.new Solution();
        solution.canJump(new int[]{3,2,1,0,4});
    }
}
