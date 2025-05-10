package 贪心;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L763_划分字母区间 {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (int i = 0; i <= s.length() - 1; i++) {
                hashMap.put(s.charAt(i), i);
            }
            int max = hashMap.get(s.charAt(0));
            List<Integer> ans = new ArrayList<>();
            int tem = 0;
            for (int i = 0; i <= s.length() - 1; i++) {
                tem++;
                max = Integer.max(max, hashMap.get(s.charAt(i)));
                if (i == max) {
                    ans.add(tem);
                    tem = 0;
                }
            }
            return ans;
        }
    }
}
