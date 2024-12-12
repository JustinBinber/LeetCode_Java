import java.util.HashSet;

public class L57_文物朝代判断 {
    class Solution {
        public boolean checkDynasty(int[] places) {
            int count_0 = 0;
            HashSet<Integer> hset = new HashSet<>();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= places.length - 1; i++) {
                if (places[i] == 0) {
                    count_0++;
                }
                else {
                    if (hset.contains(places[i])) {
                        return false;
                    }
                    hset.add(places[i]);
                    if (places[i] < min) {
                        min = places[i];
                    }
                    if (places[i] > max) {
                        max = places[i];
                    }
                }
            }
            if (hset.size() + count_0 >= max - min + 1) {
                return true;
            }
            return false;
        }


    }
    public static void main(String[] args) {
        int[] str = {0, 0, 0, 0, 0};
        L57_文物朝代判断 outer = new L57_文物朝代判断();
        L57_文物朝代判断.Solution solution = outer.new Solution();
        boolean b = solution.checkDynasty(str);
        System.out.println(b);

    }

}


