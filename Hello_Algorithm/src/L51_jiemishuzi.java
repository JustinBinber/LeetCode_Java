public class L51_jiemishuzi{
    class Solution {
        public int crackNumber(int ciphertext) {
            String str = String.valueOf(ciphertext);
            return solve(str, str.length() - 1);
        }
        public int solve(String str, int idx) {
            if (idx == 0) return 1;
            int first = Character.getNumericValue(str.charAt(idx - 1));
            int sec = Character.getNumericValue(str.charAt(idx));
            if (idx == 1) {
               if (first * 10 + sec <= 25 && first != 0) return 2;
               return 1;
            }
            else {
                if ( first * 10 + sec <= 25 && first != 0) return solve(str,idx - 1) + solve(str, idx - 2);
                else return solve(str,idx - 1);
            }
        }
    }
}
