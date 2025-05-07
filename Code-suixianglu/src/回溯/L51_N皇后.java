package 回溯;

import java.util.ArrayList;
import java.util.List;

public class L51_N皇后 {
    class Solution {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int[][] tem;
        public List<List<String>> solveNQueens(int n) {
            tem = new int[n][n];
            recur(0, n, tem);
            return ans;
        }
        public void recur(int idx, int n, int[][] tem){
            if (idx == n){
                list = new ArrayList<>();
                for (int i = 0; i <= n - 1; i++) {
                    StringBuilder a = new StringBuilder();
                    for (int j = 0; j <= n - 1; j++) {
                       if (tem[i][j] == 10) a.append('Q');
                       else a.append('.');
                    }
                    list.add(a.toString());
                }
                ans.add(list);
                return;
            }

            // 第i列
            for (int i = 0; i <= n - 1; i++) {
                // ！=0表示这个位置不能放置皇后
                if (tem[idx][i] != 0) continue;
                tem[idx][i] = 10;
                plus(tem, idx, i);
                recur(idx + 1, n, tem);
                tem[idx][i] = 0;
                sub(tem, idx, i);
            }
        }
        public void plus(int[][] tem, int x, int y){
            for (int i = 0; i <= tem.length - 1; i++) {
                for (int j = 0; j <= tem.length - 1; j++) {
                    if (!(i == x && j == y) && (i == x || j == y || (y - j == x - i) || (y - j == -(x - i)))){
                        tem[i][j] ++;
                    }
                }
            }
        }
        public void sub(int[][] tem, int x, int y){
            for (int i = 0; i <= tem.length - 1; i++) {
                for (int j = 0; j <= tem.length - 1; j++) {
                    if (!(i == x && j == y) && (i == x || j == y || (y - j == x - i) || (y - j == -(x - i)))){
                        tem[i][j] --;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        L51_N皇后 l51N皇后 = new L51_N皇后();
        Solution solution = l51N皇后.new Solution();
        solution.solveNQueens(4);
    }
}
