import java.util.HashMap;

public class L52_zhaoshichaijie {

    class Solution {
        public int dismantlingAction(String arr) {
            HashMap<Character, Integer> hmap = new HashMap();
            int len = 0;
            int max = 0;
            int idx = 0;
            for (int i = 0; i < arr.length(); i++) {
                char c = arr.charAt(i);
                if (!hmap.containsKey(c)) {
                    hmap.put(c, i);
                    len++;
                }
                else {
                    if (hmap.get(c) > idx) {idx = hmap.get(c);}
                    hmap.put(c, i);
                    len = i - idx;
                }
                if (len > max) {
                    max = len;
                }

            }
            return max;
        }
    }

    public static void main(String[] args) {
        L52_zhaoshichaijie obj = new L52_zhaoshichaijie();
        L52_zhaoshichaijie.Solution solution = obj.new Solution();
        String arr = "abba";
        System.out.println(solution.dismantlingAction(arr));
    }
}
