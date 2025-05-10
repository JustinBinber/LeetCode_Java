package 贪心;

/**
 * @author: yangjiabin
 * @date: 2025/5/7 10:42
 * @desc:
 */
public class L53_最大子数组和 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= nums.length - 1; i++) {
                if (sum <= 0 && nums[i] > sum){
                    sum = nums[i];
                }else {
                    sum += nums[i];
                }
                max = Integer.max(max, sum);
            }
            return max;
        }
    }
}
