package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangjiabin
 * @date: 2025/5/3 15:46
 * @desc:
 */
public class L93_复原IP地址 {

    class Solution {
        List<String> ans = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        public List<String> restoreIpAddresses(String s) {
            recur(s, 0, 0);
            return ans;
        }
        public void recur(String s, int idx, int pointNum){
           if (pointNum == 4 && idx == s.length()){
               ans.add(stringBuilder.toString().substring(0, stringBuilder.length() - 1));
               return;
           }else if (idx == s.length() || pointNum >= 4){
               return;
           }
            for (int i = idx; i <= s.length() - 1; i++) {
                if (!isValid(s.substring(idx, i + 1))) continue;

                stringBuilder.append(s, idx, i + 1);
                stringBuilder.append('.');
                recur(s, i + 1, pointNum + 1);
                stringBuilder.delete(stringBuilder.length() - (i + 1 - idx) - 1, stringBuilder.length());
            }

        }

        public boolean isValid(String s) {
            if (s.length() >= 4) return false;
            if (s.length() >= 2 && s.charAt(0) == '0') return false;
            int sum = Integer.parseInt(s);
            if (sum >= 256) return false;
            return true;
        }
    }

    public static void main(String[] args) {
        L93_复原IP地址 l93_复原IP地址 = new L93_复原IP地址();
        Solution solution = l93_复原IP地址.new Solution();
        solution.restoreIpAddresses(new String("25525511135"));
    }
}
