package 单调栈;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: yangjiabin
 * @date: 2025/5/18 10:12
 * @desc:
 */
public class L739_每日温度 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> stack = new Stack<Integer>();
            int[] ans = new int[temperatures.length];
            for (int i = 0; i <= temperatures.length - 1; i++) {
                if (stack.isEmpty()){
                    stack.add(i);
                    continue;
                }
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    Integer popped = stack.pop();
                    ans[popped] = i - popped;
                }
                stack.add(i);
            }
            return ans;
        }
    }
}
