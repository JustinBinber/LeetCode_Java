package 贪心;

import java.util.Arrays;
import java.util.Comparator;

public class L406_根据身高重建队列 {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                public int compare(int[] person1, int[] person2) {
                    if (person1[0] != person2[0]) {
                        return person1[0] - person2[0];
                    } else {
                        return person2[1] - person1[1];
                    }
                }
            });
            int n = people.length;
            // 这里必须为int[n][] 如果为int[n][2]会导致数组初始化为n*2的全零矩阵
            int[][] ans = new int[n][];
            for (int[] person : people) {
                int spaces = person[1];
                for (int i = 0; i < n; ++i) {
                    if (ans[i] == null) {

                        if (spaces == 0) {
                            ans[i] = person;
                            break;
                        }
                        spaces --;
                    }
                }
            }
            return ans;
        }
    }


    public static void main(String[] args) {
        L406_根据身高重建队列 l406_根据身高重建队列 = new L406_根据身高重建队列();
        Solution solution = l406_根据身高重建队列.new Solution();
        int[][] ints = solution.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        System.out.println(Arrays.deepToString(ints));
    }
}
