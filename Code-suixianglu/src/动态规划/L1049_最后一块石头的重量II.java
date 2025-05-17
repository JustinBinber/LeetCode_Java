package 动态规划;

public class L1049_最后一块石头的重量II {
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int sum = 0;
            for (int i = 0; i <= stones.length - 1; i++) {
                sum += stones[i];
            }
            int target = sum / 2;

            int[][] danamic = new int[stones.length + 1][target + 1];
            for (int i = 1; i <= stones.length; i++) {
                for (int j = 1; j <= target; j++) {
                    if (j >= stones[i - 1]) danamic[i][j] = Integer.max(danamic[i - 1][j], danamic[i - 1][j - stones[i - 1]] + stones[i - 1]);
                    else danamic[i][j] = danamic[i - 1][j];
                }
            }
            return Math.abs(sum - 2 * danamic[stones.length][target]);
        }
    }
}
