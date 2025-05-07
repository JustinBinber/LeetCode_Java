package 回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: yangjiabin
 * @date: 2025/5/3 18:12
 * @desc:
 */
public class L78_子集 {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> tem = new ArrayDeque<>();
        public List<List<Integer>> subsets(int[] nums) {
            recur(nums, 0);
            return ans;
        }

        public void recur(int[] nums, int left){
            if (left == nums.length) {
                ans.add(new ArrayList<>(tem));
                return;
            }
            else ans.add(new ArrayList<>(tem));

            for (int i = left; i <= nums.length - 1; i++) {
                tem.add(nums[i]);
                recur(nums, i + 1);
                tem.pollLast();
            }
        }
    }
}
