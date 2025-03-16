package 栈与队列;

import java.util.Objects;
import java.util.Stack;

public class L150_逆波兰表达式求值 {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> objects = new Stack<>();
            for (int i = 0; i <= tokens.length - 1; i++) {
                if (Objects.equals(tokens[i], "+")){
                    Integer subpop = objects.pop();
                    Integer pop = objects.pop();
                    objects.add(pop + subpop);
                }
                else if (Objects.equals(tokens[i], "-")){
                    Integer subpop = objects.pop();
                    Integer pop = objects.pop();
                    objects.add(pop - subpop);
                }
                else if (Objects.equals(tokens[i], "*")){
                    Integer subpop = objects.pop();
                    Integer pop = objects.pop();
                    objects.add(pop * subpop);
                }
                else if (Objects.equals(tokens[i], "/")){
                    Integer subpop = objects.pop();
                    Integer pop = objects.pop();
                    objects.add(pop / subpop);
                }
                else {
                    objects.add(Integer.valueOf(tokens[i]));
                }
            }
            return objects.pop();
        }
    }
}
