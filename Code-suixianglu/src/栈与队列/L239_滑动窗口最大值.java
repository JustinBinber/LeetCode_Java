package 栈与队列;

import java.util.Deque;
import java.util.LinkedList;

public class L239_滑动窗口最大值 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new LinkedList<>();
            int i = 0, j = k;
            // 窗口大小比数组长
            int[] ans = new int[nums.length - k + 1];
            if (j >= nums.length) {
                int max = Integer.MIN_VALUE;
                for (int l = 0; l <= nums.length - 1; l++) {
                    if (nums[l] >= max) max = nums[l];
                }
                return new int[]{max};
            }

            // 正常初始化
            j = 0;
            for (int l = 0; l <= k - 1; l++) {
                if (deque.isEmpty()) deque.add(nums[l]);
                else if (deque.peekLast() <= nums[l]) {
                    while (!deque.isEmpty() && deque.peekLast() < nums[l]){
                        deque.pollLast();
                    }
                    deque.addLast(nums[l]);
                }
                else deque.addLast(nums[l]);
                j++;
            }
            ans[i++] = deque.peek();

            while (j <= nums.length - 1){

                if (nums[i - 1] == deque.peek()) deque.pollFirst();
                if (deque.isEmpty()) deque.add(nums[j]);
                else if (deque.peekLast() <= nums[j]) {
                    while (!deque.isEmpty() && deque.peekLast() < nums[j]){
                        deque.pollLast();
                    }
                    deque.addLast(nums[j]);
                }
                else deque.addLast(nums[j]);
                ans[i] = deque.peek();
                j++;
                i++;
            }
            return ans;
        }
    }
}
