package 动态规划;

public class L509_斐波那契数 {
    class Solution {
        public int fib(int n) {
            int[] fibArray = new int[n + 2];
            fibArray[0] = 0;
            fibArray[1] = 1;
            for (int i = 2; i <= n ; i++) {
                fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
            }
            return fibArray[n];
        }
    }
}
