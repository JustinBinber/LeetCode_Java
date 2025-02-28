package 数组;

/**
 * @author: yangjiabin
 * @date: 2025/2/28 11:19
 * @desc:
 */
public class L209_长度最小的子数组 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0,right = 0,sum = 0, len = Integer.MAX_VALUE, tem = 0;
            while (right <= nums.length - 1){
                sum += nums[right];
                while (sum >= target && left <= right){
                    tem = right - left + 1;
                    len = Integer.min(len, tem);
                    sum -= nums[left];
                    left ++;
                }
                right ++;
            }
            if (len == Integer.MAX_VALUE) return 0;
            return len;

        }
    }
}
