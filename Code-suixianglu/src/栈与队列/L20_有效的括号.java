package 栈与队列;

import java.util.Stack;

public class L20_有效的括号 {
    class Solution {
        public boolean isValid(String s) {
            Stack<String> stack = new Stack<String>();
            for (int i = 0; i <= s.length() - 1; i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                    stack.add(String.valueOf(s.charAt(i)));
                else {
                    if (stack.isEmpty()) return false;
                    else if (s.charAt(i) == ')' && !stack.pop().equals("(")
                                || s.charAt(i) == ']' && !stack.pop().equals("[")
                                || s.charAt(i) == '}' && !stack.pop().equals("{")) {
                        return false;
                    }
                }
            }
            if (!stack.isEmpty()) return false;
            return true;
        }
    }

    public static void main(String[] args) {
        L20_有效的括号 l20_有效的括号 = new L20_有效的括号();
        Solution solution = l20_有效的括号.new Solution();
        solution.isValid("{}");
    }
}

