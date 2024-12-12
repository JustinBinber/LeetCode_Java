public class L56_模糊搜索验证 {
/*    class Solution {
        public boolean articleMatch(String s, String p) {
            int i = 0, j = 0;
            boolean flag = true;
            while (i < s.length() && j < p.length() - 1) {
                if ( (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' ) && p.charAt(i + 1) >= 'a' && s.charAt(i + 1) <= 'z') {
                    i++;
                    j++;
                }
                else if (s.charAt(i) == p.charAt(j) && p.charAt(i + 1) == '*') {
                    while (i < s.length() && s.charAt(i) == p.charAt(j)) {
                        i++;
                    }
                    j += 2;
                }
                else if ( (s.charAt(i) != p.charAt(j) && p.charAt(j) != '.') && p.charAt(i + 1) == '*') {
                    i++;
                    j += 2;
                }
                else if ( p.charAt(j) == '.' && p.charAt(i + 1) == '*') {
                    return true;
                }
                else {
                    return false;
                }
            }

            if (i < s.length() - 1 || j < p.length() - 1) {
                flag = false;
            }
            return flag;
        }
    }*/

    class Solution {
        public boolean articleMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            if (p.length() > 0) dp[0][1] = false;

            for (int j = 2; j <= p.length(); j++){
                if (p.charAt(j - 1) == '*' && dp[0][j - 2]){
                    dp[0][j] = true;
                } else {
                    dp[0][j] = false;
                }
            }
            for (int i = 1; i <= s.length(); i++){
                dp[i][0] = false;
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if (p.charAt(j - 1) == '*'){
                        dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && p.charAt(j - 2) == s.charAt(i - 1))
                                || (dp[i - 1][j] && p.charAt(j - 2) == '.');
                    }
                    else {
                        dp[i][j] = (dp[i - 1][j - 1] && (p.charAt(j - 1) == s.charAt(i - 1) ||p.charAt(j - 1) == '.'));
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*b*c*";
        L56_模糊搜索验证 outer = new L56_模糊搜索验证();
        L56_模糊搜索验证.Solution solution = outer.new Solution();
        boolean b = solution.articleMatch(s, p);
        System.out.println(b);

    }
}
