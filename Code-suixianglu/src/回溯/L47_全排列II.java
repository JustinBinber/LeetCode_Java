package 回溯;

import java.util.*;

/**
 * @author: yangjiabin
 * @date: 2025/5/4 14:33
 * @desc:
 */
public class L47_全排列II {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> tem = new ArrayDeque<>();
        HashSet<Integer> hashSet = new HashSet<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            recur(nums);
            return ans;
        }

        public void recur(int[] nums){
            if (tem.size() == nums.length){
                ans.add(new ArrayList<>(tem));
                return;
            }

            HashSet<Integer> temHash = new HashSet<>();

            for (int i = 0; i <= nums.length - 1; i++) {
                if (hashSet.contains(i) || temHash.contains(nums[i])) continue;

                hashSet.add(i);
                temHash.add(nums[i]);
                tem.add(nums[i]);
                recur(nums);
                tem.pollLast();
                hashSet.remove(i);

            }
        }
    }
}
