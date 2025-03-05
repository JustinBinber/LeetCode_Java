package 哈希表;

import javax.xml.stream.FactoryConfigurationError;
import java.util.HashMap;

/**
 * @author: yangjiabin
 * @date: 2025/3/5 17:32
 * @desc:
 */
public class L1_两数之和 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
            int[] ans = new int[2];
            for (int i = 0; i <= nums.length - 1; i++) {
                hashMap.put(nums[i], i);
            }
            for (int i = 0; i <= nums.length - 1; i++) {
                Integer i1 = hashMap.get(target - nums[i]);
                if (i1 != null && i != i1){
                    ans[0] = i;
                    ans[1] = i1;
                    return ans;
                }

            }
            return null;
        }
    }

}
