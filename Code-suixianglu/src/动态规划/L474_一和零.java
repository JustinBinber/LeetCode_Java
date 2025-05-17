package 动态规划;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L474_一和零 {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
            for (int i = 0; i <= strs.length - 1; i++) {
                int countOne = 0;
                for (int j = 0; j <= strs[i].length() - 1; j++) {
                    if (strs[i].charAt(j) == '1') countOne++;
                }
                List<Integer> list = new ArrayList<>();
                list.add(countOne);
                hashMap.put(i, list);
            }

            // 表示考虑前i个字符中，j个0，k个1的最大长度
            int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
            for (int i = 1; i <= strs.length; i++) {
                for (int j = 0; j <= m; j++) {
                    for (int k = 0; k <= n; k++) {
                        int zeroLen = strs[i - 1].length() - hashMap.get(i - 1).get(0);
                        int oneLen = hashMap.get(i - 1).get(0);
                        if (j >= zeroLen && k >= oneLen) dp[i][j][k] = Integer.max(dp[i - 1][j][k], dp[i - 1][j - zeroLen][k - oneLen] + 1);
                        else dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
            return dp[strs.length][m][n];
        }
    }

    public static void main(String[] args) {
        L474_一和零 l474_一和零 = new L474_一和零();
        Solution solution = l474_一和零.new Solution();
        System.out.println(solution.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));

    }
}
