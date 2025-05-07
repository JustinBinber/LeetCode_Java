package 贪心;

import java.util.Arrays;

public class L455_分发饼干 {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int idxMax = s.length - 1;
            int ans = 0;
            for (int i = g.length - 1; i >= 0; i--) {
                if (idxMax >= 0 && s[idxMax] >= g[i]){
                    ans++;
                    idxMax--;
                }
            }
            return ans;
        }
    }
}
