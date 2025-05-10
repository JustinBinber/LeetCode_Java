package 贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L56_合并区间 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
            int maxRight = -1;
            int minLeft = intervals[0][0];
            List<int[]> ans = new ArrayList<>();
            for (int i = 0; i <= intervals.length; i++) {
                // 可以扩大
                if (i == intervals.length){
                    int[] ints = new int[2];
                    ints[0] = minLeft;
                    ints[1] = maxRight;
                    ans.add(ints);
                    continue;
                }
                if (intervals[i][0] <= maxRight || maxRight == -1){
                    maxRight = Integer.max(maxRight, intervals[i][1]);
                    continue;
                }
                int[] ints = new int[2];
                ints[0] = minLeft;
                ints[1] = maxRight;
                ans.add(ints);
                minLeft = intervals[i][0];
                maxRight = intervals[i][1];
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }

    class Solution_daan {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][2];
            }
            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] interval1, int[] interval2) {
                    return interval1[0] - interval2[0];
                }
            });
            List<int[]> merged = new ArrayList<int[]>();
            for (int i = 0; i < intervals.length; ++i) {
                int L = intervals[i][0], R = intervals[i][1];
                if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                    merged.add(new int[]{L, R});
                } else {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }
    }

    public static void main(String[] args) {
        L56_合并区间 l56_合并区间 = new L56_合并区间();
        Solution solution = l56_合并区间.new Solution();
        int[][] tem = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        solution.merge(tem);
    }
}
