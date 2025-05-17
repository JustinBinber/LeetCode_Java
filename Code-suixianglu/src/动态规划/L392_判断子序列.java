package 动态规划;

import java.util.Objects;

public class L392_判断子序列 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if (Objects.equals(s, "")) return false;
            int idx = 0;
            for (int i = 0; i <= t.length() - 1; i++) {
                if (s.charAt(idx) == t.charAt(i)) idx++;
                if (idx == s.length() - 1) return true;
            }
            return false;
        }
    }
}
