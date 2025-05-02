package 回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L77_组合 {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        public List<List<Integer>> combine(int n, int k) {
            recur(1, n, k);
            return ans;
        }
        public void recur(int min, int max, int k){
//            if (min > max) {
//                path = new ArrayDeque<>();
//                return;
//            }
            if (k == 0) {
                ans.add(new ArrayList<>(path));
                // path = new ArrayDeque<>();
                return;
            }
            for (int i = min; i <= max; i++) {
                path.add(i);
                recur(i + 1, max, k - 1);
                path.pollLast();
            }

        }
    }

    public static void main(String[] args) {
        L77_组合 l77_组合 = new L77_组合();
        Solution solution = l77_组合.new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);
    }
}
