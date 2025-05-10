package 动态规划;

public class L746_使用最小花费爬楼梯 {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] array = new int[cost.length];
            array[0] = cost[0];
            array[1] = cost[1];
            for (int i = 2; i <= cost.length - 1; i++) {
                array[i] = cost[i] + Integer.min(array[i - 1], array[i - 2]);
            }
            return Integer.min(array[array.length - 1], array[array.length - 2]);
        }
    }
}
