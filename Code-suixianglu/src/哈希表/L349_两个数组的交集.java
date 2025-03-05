package 哈希表;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author: yangjiabin
 * @date: 2025/3/5 16:38
 * @desc:
 */
public class L349_两个数组的交集 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> hashSet1 = new HashSet<>();
            HashSet<Integer> hashSet2 = new HashSet<>();
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i <= nums1.length - 1; i++) {
                hashSet1.add(nums1[i]);
            }
            for (int i = 0; i <= nums2.length - 1; i++) {
                if (hashSet1.contains(nums2[i]) && !hashSet2.contains(nums2[i])){
                    ans.add(nums2[i]);
                    hashSet2.add(nums2[i]);
                }

            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static void main(String[] args) {
        L349_两个数组的交集 l349_两个数组的交集 = new L349_两个数组的交集();
        Solution solution = l349_两个数组的交集.new Solution();
        int[] a = {1};
        int[] b = {1};

        int[] intersection = solution.intersection(a, b);
    }
}
