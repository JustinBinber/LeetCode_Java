package 动态规划;

public class L62_不同路径 {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] tem = new int[m][n];
            for (int i = 0; i <= m - 1; i++) {
                for (int j = 0; j <= n - 1; j++) {
                    if (i == 0 || j == 0) tem[i][j] = 1;
                    else tem[i][j] = tem[i - 1][j] + tem[i][j - 1];
                }
            }
            return tem[m - 1][n - 1];
        }
    }
}
