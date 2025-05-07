package 回溯;

import java.lang.reflect.AnnotatedArrayType;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: yangjiabin
 * @date: 2025/5/3 18:23
 * @desc:
 */
public class L90_子集II {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> tem = new ArrayDeque<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            // 1000是没出现过得数字，题目中给定范围是正负10
            recur(nums, -1000, 0);
            return ans;
        }

        //  last是上次没选的数
        public void recur(int[] nums, int last, int idx){
            if (idx == nums.length){
                ans.add(new ArrayList<>(tem));
                return;
            }else {
                ans.add(new ArrayList<>(tem));
            }

            for (int i = idx; i <= nums.length - 1; i++) {
                if (nums[i] == last) continue;
                tem.add(nums[i]);
                recur(nums, last, i + 1);
                tem.pollLast();
                last = nums[i];
            }
        }
    }
}
