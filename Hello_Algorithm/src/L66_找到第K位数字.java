import com.sun.tools.javac.Main;

public class L66_找到第K位数字 {
    class Solution {
        public int findKthNumber(int k) {
            Integer weishu = 0, index = 0,pianyi = 0, sum_kth = 0;
            while (k > sum_kth){
                k = k - sum_kth;
                weishu ++;
                sum_kth = (int) (weishu * 9 * Math.pow(10, weishu - 1));
            }
            index = (k - 1)/ (weishu );
            //这里要减去1，因为是从1开始的，如果输入10，应该是对应两位数里面的第0个，但是只减了9
            //190对应的是三位数第一个（9 + 2 * 90） 也就是100
            pianyi = (k - 1) % (weishu );
            int num = (int) (Math.pow(10, weishu - 1) + index);

            return Integer.toString(num).charAt(pianyi) - '0';
        }
    }

    public static void main(String[] args) {
        L66_找到第K位数字 out = new L66_找到第K位数字();
        L66_找到第K位数字.Solution solution = out.new Solution();
        int kthNumber = solution.findKthNumber(12);
        System.out.println(kthNumber);
    }
}
