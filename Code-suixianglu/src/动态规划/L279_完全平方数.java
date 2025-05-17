package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class L279_完全平方数 {
    /**
     * 其实没必要创建list，将i*i作为物品就可以，见答案
     */
    class Solution {
        public int numSquares(int n) {
            int square = 1;
            int num = 2;
            List<Integer> list = new ArrayList<>();
            while (square <= 10000){
                list.add(square);
                square = (int) Math.pow(num, 2);
                num++;
            }
            int[] dp = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                dp[i] = 10000;
            }
            dp[0] = 0;
            for (int i = 0; i <= list.size() - 1; i++) {
                for (int j = 0; j <= n; j++) {
                    if (j >= list.get(i)) dp[j] = Integer.min(dp[j], dp[j - list.get(i)] + 1);
                }
            }
            return dp[n];
        }
    }
    class Solution_ans {
        // 版本一，先遍历物品, 再遍历背包
        public int numSquares(int n) {
            int max = Integer.MAX_VALUE;
            int[] dp = new int[n + 1];
            //初始化
            for (int j = 0; j <= n; j++) {
                dp[j] = max;
            }
            //如果不想要寫for-loop填充數組的話，也可以用JAVA內建的Arrays.fill()函數。
            //Arrays.fill(dp, Integer.MAX_VALUE);

            //当和为0时，组合的个数为0
            dp[0] = 0;
            // 遍历物品
            for (int i = 1; i * i <= n; i++) {
                // 遍历背包
                for (int j = i * i; j <= n; j++) {
                    //if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                    //}
                    //不需要這個if statement，因爲在完全平方數這一題不會有"湊不成"的狀況發生（ 一定可以用"1"來組成任何一個n），故comment掉這個if statement。
                }
            }
            return dp[n];
        }
    }
}
