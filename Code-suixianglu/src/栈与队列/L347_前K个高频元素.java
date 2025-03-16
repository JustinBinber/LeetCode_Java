package 栈与队列;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class L347_前K个高频元素 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int[] ans = new int[k];
            for (int i = 0; i <= nums.length - 1; i++) {
                hashMap.put(nums[i],hashMap.getOrDefault(nums[i], 0) + 1);
            }

            Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();

            PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(k, (a,  b) -> {
                return a.getValue() - b.getValue();
            });

            for (Map.Entry<Integer, Integer> entry : entries){
                if (priorityQueue.size() < k) priorityQueue.add(entry);
                else if (entry.getValue() > priorityQueue.peek().getValue()){
                    priorityQueue.poll();
                    priorityQueue.add(entry);
                }
            }

            for (int i = priorityQueue.size() - 1; i >= 0 ; i--) {
                ans[i] = priorityQueue.poll().getKey();
            }
            return ans;
        }
    }
}
