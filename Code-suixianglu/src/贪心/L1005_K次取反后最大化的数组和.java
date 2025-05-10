package 贪心;

import java.util.Arrays;

/**
 * @author: yangjiabin
 * @date: 2025/5/7 17:20
 * @desc:
 */
public class L1005_K次取反后最大化的数组和 {
    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            Arrays.sort(nums);
            int negCount = 0;
            int zeroCount = 0;
            int posCount = 0;
            int sum = 0;
            for (int i = 0; i <= nums.length - 1; i++) {
                if (nums[i] == 0) zeroCount++;
                else if (nums[i] > 0) posCount++;
                else negCount ++;
            }
            if (k >= negCount){
                if (zeroCount != 0 || k == negCount || (k - negCount) % 2 == 0){
                    for (int i = 0; i <= nums.length - 1; i++) {
                        sum += Math.abs(nums[i]);
                    }
                }
                else {
                    int min = Integer.MAX_VALUE;
                    for (int i = 0; i <= nums.length - 1; i++) {
                        nums[i] = Math.abs(nums[i]);
                        sum += nums[i];
                        min = Integer.min(min, nums[i]);
                    }
                    sum -= min * 2;
                }
            }
            else {
                for (int i = 0; i <= k - 1; i++) {
                    nums[i] = - nums[i];
                }
                for (int i = 0; i <= nums.length - 1; i++) {
                    sum += nums[i];
                }
            }
            return sum;
        }
    }
}
