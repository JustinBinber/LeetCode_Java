package 贪心;

/**
 * @author: yangjiabin
 * @date: 2025/5/7 16:51
 * @desc:
 */
public class L45_跳跃游戏II {
    class Solution {
        public int jump(int[] nums) {
            int left = 0;
            int right = 0;
            int ans = 0;
            while (right < nums.length - 1){
                int tem = right;
                for (int i = left; i <= tem; i++) {
                    right = Integer.max(right, i + nums[i]);
                }
                left = tem++;
                ans++;
            }
            return ans - 1;
        }
    }
}
