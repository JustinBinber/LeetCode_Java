import java.util.ArrayList;
import java.util.List;

public class L54_UglyNum {
    class Solution {
        public int nthUglyNumber(int n) {
            List<Integer> list = new ArrayList<Integer>();
            int idx_a = 0, idx_b = 0, idx_c = 0;
            int a, b, c = 0;
            int min = Integer.MAX_VALUE;
            list.add(1);
            for (int i =0; i < n; i++){
                a = list.get(idx_a) * 2;
                b = list.get(idx_b) * 3;
                c = list.get(idx_c) * 5;
                min = Math.min(Math.min(a, b), c);
                list.add(min);
                if (min == a) idx_a++;
                if (min == b) idx_b++;
                if (min == c) idx_c++;
            }
            return list.get(list.size() - 2);
        }
    }
}
