package 哈希表;

import java.util.HashMap;

/**
 * @author: yangjiabin
 * @date: 2025/3/5 17:42
 * @desc:
 */
public class L454_四数相加II {
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            HashMap<Integer, Integer> hashMap1 = new HashMap<>();
            HashMap<Integer, Integer> hashMap2 = new HashMap<>();
            int ans = 0;

            int len = nums1.length;
            for (int i = 0; i <= len - 1; i++) {
                for (int j = 0; j <= len - 1; j++){
                    int sum = 0;
                    sum = nums1[i] + nums2[j];
                    if (hashMap1.containsKey(sum)){
                        hashMap1.compute(sum, (k, times) -> times + 1);
                    }
                    else {
                        hashMap1.put(sum, 1);
                    }
                }
            }


            for (int i = 0; i <= len - 1; i++) {
                for (int j = 0; j <= len - 1; j++){
                   int sum = nums3[i] + nums4[j];
                   if (hashMap1.containsKey(-sum)){
                       ans += hashMap1.get(-sum);
                   }
                }
            }
            return ans;
        }
    }
}
