package 回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L216_组合总和III {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> tem = new ArrayDeque<>();
        public List<List<Integer>> combinationSum3(int k, int n) {
            recur(k, 1, n);
            return ans;
        }
        public void recur(int k, int min, int n){
            if (n == 0 && k == 0) {
                ans.add(new ArrayList<>(tem));
                return;
            } else if (n < 0) {
                return;
            }

            for (int i = min; i <= 9; i++) {
                tem.add(i);
                recur(k - 1, i + 1, n - i);
                tem.pollLast();
            }

        }
    }
}
