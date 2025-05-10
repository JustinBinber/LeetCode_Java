package 贪心;

import java.util.Arrays;

public class L452_用最少数量的箭引爆气球 {
    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length <= 1) return points.length;
            Arrays.sort(points, (int[] a, int[] b) -> {
                if (a[0] != b[0]){
                    return Integer.compare(a[0] , b[0]);
                }else {
                    return Integer.compare(a[1] , b[1]);
                }
            });
            int ans = 1;
            int right = 1;
            int left = 0;
            while (right <= points.length - 1){
                // 16 27 2<6
                if (points[right][0] <= points[left][1]){
                    right++;
                    continue;
                }
                left = right;
                right++;
                ans++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        L452_用最少数量的箭引爆气球 l452_用最少数量的箭引爆气球 = new L452_用最少数量的箭引爆气球();
        Solution solution = l452_用最少数量的箭引爆气球.new Solution();
        System.out.println(solution.findMinArrowShots(new int[][]{{1,2}, {1,5}, {4, 5}}));
    }
}
