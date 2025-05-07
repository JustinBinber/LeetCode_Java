package 回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: yangjiabin
 * @date: 2025/5/2 10:43
 * @desc:
 */
public class L40_组合总和II {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> tem = new ArrayDeque<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            recur(candidates, target, 0);
            return ans;
        }
        public void recur(int[] candidates, int target, int idx){
            if (target == 0) {
                ans.add(new ArrayList<>(tem));
                return;
            } else if (target < 0 ) {
                return;
            }

            for (int i = idx; i <= candidates.length - 1; i++) {
                tem.add(candidates[i]);
                recur(candidates, target - candidates[i], i + 1);
                tem.pollLast();
            }
        }

    }

    public static void main(String[] args) {
        L40_组合总和II l40_组合总和II = new L40_组合总和II();
        Solution solution = l40_组合总和II.new Solution();
        solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
