package 回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L39_组合总和 {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> tem = new ArrayDeque<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            recur(candidates, target, 0);
            return ans;
        }
        public void recur(int[] candidates, int target, int idx){
            if (target == 0){
                ans.add(new ArrayList<>(tem));
                return;
            } else if (target < 0) {
                return;
            }

            for (int i = idx; i <= candidates.length - 1; i++) {
                tem.add(candidates[i]);
                recur(candidates, target - candidates[i], i);
                tem.pollLast();
            }
        }
    }
}
