public class L53_MaxValue {

/*    这种方法会超时,是暴力的递归
    class Solution {
        public int jewelleryValue(int[][] frame) {
            return iter(frame, 0, 0);
        }
        public int iter(int[][] frame, int idx_col, int idx_row){
            if (idx_row >= frame[0].length || idx_col >= frame.length) return 0;
            else if (idx_row == frame[0].length - 1 && idx_col == frame.length - 1)
                return frame[frame.length - 1][frame[0].length - 1];
            return frame[idx_col][idx_row] +
                    Math.max(iter(frame, idx_col + 1, idx_row), iter(frame, idx_col, idx_row + 1));
        }

    }*/
class Solution {
    public int jewelleryValue(int[][] frame) {
        int m = frame.length, n = frame[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) frame[i][j] += frame[i][j - 1] ;
                else if(j == 0) frame[i][j] += frame[i - 1][j];
                else frame[i][j] += Math.max(frame[i][j - 1], frame[i - 1][j]);
            }
        }
        return frame[m - 1][n - 1];
    }
}


    public static void main(String[] args) {
        L53_MaxValue outer = new L53_MaxValue(); // 实例化外部类
        Solution s = outer.new Solution(); // 使用外部类的实例来创建 Solution 的实例
        int[][] frame = {{1, 2, 5}, {3, 2, 1}};
        int ans = s.jewelleryValue(frame);
        System.out.println(ans); // 打印结果
    }
}
