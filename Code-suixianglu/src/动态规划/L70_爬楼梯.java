package 动态规划;

public class L70_爬楼梯 {
    class Solution {
        public int climbStairs(int n) {
            int[] fibArray = new int[n + 2];
            fibArray[1] = 1;
            fibArray[2] = 2;
            for (int i = 3; i <= n ; i++) {
                fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
            }
            return fibArray[n];
        }
    }
}
