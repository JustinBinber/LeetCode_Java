package 贪心;

import java.util.Arrays;
import java.util.Comparator;

public class L435_无重叠区间 {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[1]));
            int minRight = intervals[0][1];
            int pingtai = 1;
            for (int i = 0; i <= intervals.length - 1; i++) {
                if (intervals[i][0] < minRight) continue;
                minRight = intervals[i][1];
                pingtai++;
            }
            return intervals.length - pingtai;
        }
    }
}
