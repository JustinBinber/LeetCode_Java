package 栈与队列;

import java.util.Stack;

public class L1047_删除字符串中的所有相邻重复项 {
    class Solution {
        public String removeDuplicates(String s) {
            Stack<Character> stack = new Stack<>();
            StringBuilder string = new StringBuilder(new String());
            for (int i = 0; i <= s.length() - 1 ; i++) {
                if (stack.isEmpty() || stack.peek() != s.charAt(i)){
                    stack.add(s.charAt(i));
                } else if (stack.peek() == s.charAt(i)) {
                    stack.pop();
                }
            }
            int len = stack.size();
            for (int i = 0; i <= len - 1 ; i++) {
                string.insert(0, stack.pop());
            }
            return string.toString();
        }
    }

    public static void main(String[] args) {
        L1047_删除字符串中的所有相邻重复项 l1047_删除字符串中的所有相邻重复项 = new L1047_删除字符串中的所有相邻重复项();
        Solution solution = l1047_删除字符串中的所有相邻重复项.new Solution();
        solution.removeDuplicates("abbaca");
    }
}
