package 动态规划;

public class L343_整数拆分 {
    class Solution {
        public int integerBreak(int n) {
            if (n <= 3 && n >= 2) return n - 1;
            int ans = 1;
            int yushu = n % 3;
            int num = n / 3;
            if (yushu == 1){
                if (num >= 1) {
                    ans *= 4;
                    num--;
                    ans = (int) (ans * Math.pow(3, num));
                }
            } else if (yushu == 2) {
                ans = (int) (ans * Math.pow(3, num)) * 2;
            }
            else ans = (int) (ans * Math.pow(3, num));
            return ans;
        }
    }
}
