package 数组;

import java.util.ArrayList;
import java.util.List;

public class L977_有序数组的平方 {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int i = 0;
            int j = 0;
            List<Integer> negaarray = new ArrayList<Integer>();
            List<Integer> posiarray = new ArrayList<Integer>();
            List<Integer> finalarray = new ArrayList<Integer>();

            while (i <= nums.length - 1 && nums[i] <= 0){
                negaarray.add(nums[i] * nums[i]);
                i++;
            }

            while (i <= nums.length - 1 && nums[i] > 0){
                posiarray.add(nums[i] * nums[i]);
                i++;
            }


            i = negaarray.size() - 1;
            while (i >= 0 && j <= posiarray.size() - 1){
                if (negaarray.get(i)<= posiarray.get(j)){
                    finalarray.add(negaarray.get(i));
                    i--;
                }
                else {
                    finalarray.add(posiarray.get(j));
                    j++;
                }
            }

            while (i >= 0){
                finalarray.add(negaarray.get(i));
                i--;
            }

            while (j <= posiarray.size() - 1){
                finalarray.add(posiarray.get(j));
                j++;
            }

            // 转换为int数组
            int[] result = new int[finalarray.size()];
            for (int k = 0; k < result.length; k++) {
                result[k] = finalarray.get(k);
            }

            return result;
        }
    }
}
