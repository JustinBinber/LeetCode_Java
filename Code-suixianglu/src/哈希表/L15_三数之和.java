package 哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15_三数之和 {
    class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            int left, right, len = nums.length - 1;
            Arrays.sort(nums);
            for (int i = 0; i <= len; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                left = i + 1;
                right = len;
                while (left < right && left <= len && right >= 0){
                    if (nums[left] + nums[right] > - nums[i]){
                        right--;
                    }
                    else if (nums[left] + nums[right] < - nums[i]){
                        left++;
                    }
                    else {
                        ArrayList<Integer> list = new ArrayList<>();

                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);


                        while (right > left && nums[right] == nums[right - 1]){
                            right--;
                        }


                        while (right > left && nums[left] == nums[left + 1]){
                            left++;
                        }
                        right--;
                        left++;
                    }
                }
            }
            return ans;

        }
    }

    public static void main(String[] args) {
        L15_三数之和 l15_三数之和 = new L15_三数之和();
        Solution solution = l15_三数之和.new Solution();
        solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
