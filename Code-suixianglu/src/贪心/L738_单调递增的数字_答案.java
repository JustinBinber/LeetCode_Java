package 贪心;

public class L738_单调递增的数字_答案 {
    class Solution {
        public int monotoneIncreasingDigits(int n) {
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            int start = s.length();
            for (int i = s.length() - 2; i >= 0; i--) {
                if (chars[i] > chars[i + 1]) {
                    chars[i]--;
                    start = i+1;
                }
            }
            for (int i = start; i < s.length(); i++) {
                chars[i] = '9';
            }
            return Integer.parseInt(String.valueOf(chars));
        }
    }

    public static void main(String[] args) {
        L738_单调递增的数字_答案 l738_单调递增的数字 = new L738_单调递增的数字_答案();
        Solution solution = l738_单调递增的数字.new Solution();
        System.out.println(solution.monotoneIncreasingDigits(123));
    }
}
