import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
这个是错的
 */
public class L58_砍竹子 {
/*    class Solution {
        public int cuttingBamboo(int bamboo_len) {
            if (bamboo_len == 0 || bamboo_len == 1) return 0;
            else if (bamboo_len == 2) return 1;
            else if (bamboo_len == 3) return 2;
            List<Integer> tem = new ArrayList<Integer>();
            int i, j, ans = 1;

            if (bamboo_len % 3 == 2 || bamboo_len % 3 == 0) {
                i = bamboo_len / 3;
                j = bamboo_len % 3;
                for (int k = 0; k <= i - 1; k++) {
                    tem.add(3);
                }
                if (j != 0) tem.add(j);
                for (int m = 0; m < tem.size(); m++) {
                    ans *= tem.get(m);
                }
                return ans;
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(bamboo_len);
            while (queue.size() != 0) {
                if(queue.peek() <= 3){
                    tem.add(queue.poll());
                }
                else {
                    i = queue.peek() / 2;
                    j = queue.peek() - i;
                    queue.add(i);
                    queue.add(j);
                    queue.poll();
                }
            }
            for (i = 0; i < tem.size(); i++) {
                ans *= tem.get(i);
            }
            return ans;
        }
    }*/
class Solution {
    public int cuttingBamboo(int bamboo_len) {
        if (bamboo_len <= 3){
            return bamboo_len - 1;
        }
        else {
            if (bamboo_len % 3 == 0) return (int) Math.pow(3, bamboo_len / 3);
            else if (bamboo_len % 3 == 1) return (int) Math.pow(3, bamboo_len / 3 - 1)  * 4;
            else  return (int) Math.pow(3, bamboo_len / 3)  * 2;
        }
    }
}

    public static void main(String[] args) {
        L58_砍竹子 out = new L58_砍竹子();
        L58_砍竹子.Solution s = out.new Solution();
        System.out.println(s.cuttingBamboo(16));
    }
}
