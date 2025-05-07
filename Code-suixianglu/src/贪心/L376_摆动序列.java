package 贪心;

public class L376_摆动序列 {
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length <= 1){
                return nums.length;
            }

            int[] dif = new int[nums.length - 1];
            for (int i = 1; i <= nums.length - 1; i++) {
                dif[i - 1] = nums[i] - nums[i - 1];
            }

            int last = - dif[0];
            int ans = 1;
            for (int i = 0; i <= dif.length - 1; i++) {
                if (dif[i] == 0 || dif[i] * last > 0) continue;
                ans ++;
                last = dif[i];
            }
            return ans;
        }
    }
}
