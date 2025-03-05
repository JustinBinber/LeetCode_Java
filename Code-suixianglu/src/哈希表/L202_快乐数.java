package 哈希表;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author: yangjiabin
 * @date: 2025/3/5 17:00
 * @desc:
 */
public class L202_快乐数 {
    class Solution {
        public boolean isHappy(int n) {
            HashSet<Integer> hashSet = new HashSet<>();
            while (n != 1){
                int sum = 0;
                List<Integer> bitclip = bitclip(n);
                for (int i = 0; i <= bitclip.size() - 1; i++) {
                    sum += bitclip.get(i) * bitclip.get(i);
                }
                n = sum;
                if (n == 1) return true;
                if (hashSet.contains(n)) return false;
                hashSet.add(n);
            }
            return true;
        }

        public List<Integer> bitclip(int n){
            ArrayList<Integer> list = new ArrayList<>();
            int tem;
            while (n != 0){
                list.add((n % 10));
                n = n / 10;
            }
            return list;
        }
    }

    public static void main(String[] args) {
        L202_快乐数 l202_快乐数 = new L202_快乐数();

        Solution solution = l202_快乐数.new Solution();
        boolean happy = solution.isHappy(19);
    }
}
