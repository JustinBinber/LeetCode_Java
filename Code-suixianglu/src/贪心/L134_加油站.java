package 贪心;

import javax.management.MBeanAttributeInfo;

/**
 * @author: yangjiabin
 * @date: 2025/5/7 17:39
 * @desc:
 */
public class L134_加油站 {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int gasLeft = 0;
            int idx = 0;
            while (idx <= gas.length - 1){
                int start = idx;
                int end = start;
                gasLeft = gas[start];
                for (int i = start; i <= start + gas.length - 1; i++) {
                    int cur = i % (gas.length);
                    if (gasLeft >= cost[cur]){
                        gasLeft = gasLeft + gas[(cur + 1) % (gas.length)] - cost[cur];
                        end = (end + 1) % (gas.length);
                        if (end == start) return start;
                    }else break;
                }
                if ((end + 1) % (cost.length) <= idx) break;
                idx = (end + 1) % (cost.length);
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        L134_加油站 l134_加油站 = new L134_加油站();
        Solution solution = l134_加油站.new Solution();
        int[] gas = new int[]{2,3,4};
        int[] cost = new int[]{3,4,3};
        System.out.println(solution.canCompleteCircuit(gas, cost));

    }
}
