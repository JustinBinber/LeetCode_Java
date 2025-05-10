package 动态规划;

public class L63_不同路径II {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int[][] tem = new int[obstacleGrid.length][obstacleGrid[0].length];
            boolean hasObstacle= false;
            for (int i = 0; i <= obstacleGrid[0].length - 1; i++) {
                 if (obstacleGrid[0][i] == 1) hasObstacle = true;
                if (!hasObstacle) tem[0][i] = 1;
            }
            hasObstacle = false;
            for (int i = 0; i <= obstacleGrid.length - 1; i++) {
                if (obstacleGrid[i][0] == 1) hasObstacle = true;
                if (!hasObstacle) tem[i][0] = 1;
            }
            for (int i = 1; i <= obstacleGrid.length - 1; i++) {
                for (int j = 1; j <= obstacleGrid[0].length - 1; j++) {
                    if (obstacleGrid[i][j] == 1) continue;
                    tem[i][j] = tem[i - 1][j] + tem[i][j - 1];
                }
            }
            return tem[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        }
    }
}
