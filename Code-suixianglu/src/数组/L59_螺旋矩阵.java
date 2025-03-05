package 数组;

public class L59_螺旋矩阵 {
    class Solution {
        public int[][] generateMatrix(int n) {
            int left = 0, right = n - 1, top = 0, down = n - 1;
            int j;
            int val = 1;
            int[][] ans = new int[n][n];
            for (int i = 0; i <= (n + 1)/2; i++){

                if (left == right){
                    ans[top][right] = val;
                }

                for (j = left; j <= right - 1; j++){
                    ans[top][j] = val;
                    val++;
                }


                for (j = top; j <= down - 1; j++) {
                    ans[j][right] = val;
                    val++;
                }


                for (j = right; j >= left + 1; j--) {
                    ans[down][j] = val;
                    val++;
                }


                for (j = down; j >= top + 1; j--){
                    ans[j][left] = val;
                    val++;
                }
                top++;
                left++;
                down--;
                right--;
            }
            return ans;
        }
    }
}
