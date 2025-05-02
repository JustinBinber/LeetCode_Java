package 回溯;

import java.util.*;

public class L17_电话号码的字母组合 {
    class Solution {
        List<String> ans = new ArrayList<>();
        String tem = "";
        HashMap<Integer, String> call = new HashMap<>();

        public List<String> letterCombinations(String digits) {
            call.put(2, "abc");
            call.put(3, "def");
            call.put(4, "ghi");
            call.put(5, "jkl");
            call.put(6, "mno");
            call.put(7, "pqrs");
            call.put(8, "tuv");
            call.put(9, "wxyz");
            // 这里要用equals
            if (Objects.equals(digits, "")) return new ArrayList<>();;
            recur(digits, 0);
            return ans;
        }
        public void recur(String digits, int idx){
            if (idx == digits.length()){
                ans.add(tem);
                return;
            }

            int c = (int) digits.charAt(idx) - 48;
                String string = call.get(c);

            for (int j = 0; j <= string.length() - 1; j++) {
                tem += string.charAt(j);
                recur(digits, idx + 1);
                tem = tem.substring(0, this.tem.length() - 1);
            }

        }
    }
}
