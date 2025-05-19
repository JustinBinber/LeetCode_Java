package 单调栈;

import 回溯.L46_全排列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: yangjiabin
 * @date: 2025/5/19 17:17
 * @desc:
 */
public class L42_接雨水 {
    class Solution {
        public int trap(int[] height) {
            Deque<Integer> deque = new LinkedList<>();
            int ans = 0;
            for (int i = 0; i <= height.length - 1; i++) {
                if (deque.isEmpty()) deque.addLast(i);
                else if (height[i] < height[deque.peekLast()]){
                    deque.addLast(i);
                }
                else if(height[i] == height[deque.peekLast()]){
                    deque.pollLast();
                    deque.addLast(i);
                }
                else {
                    while (!deque.isEmpty() && height[i] >= height[deque.peekLast()]){
                        Integer mid = deque.pollLast();
                        Integer left = deque.peekLast();
                        if (left != null) {
                            int kuan = i - left - 1;
                            int gao = Integer.min(height[left], height[i]) - height[mid];
                            ans += kuan * gao;
                            System.out.println(ans);
                        }
                    }
                    deque.add(i);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        L42_接雨水 l42_接雨水 = new L42_接雨水();
        Solution solution = l42_接雨水.new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
