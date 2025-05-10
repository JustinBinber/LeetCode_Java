package 动态规划;

/**
 * @author: yangjiabin
 * @date: 2025/5/10 09:48
 * @desc:
 */
public class L96_不同的二叉搜索树_答案 {
    class Solution {
        public int numTrees(int n) {
            if (n == 1) return 1;
            int[] tem = new int[n + 1];
            tem[0] = 1;
            tem[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= i - 1; j++) {
                    tem[i] += tem[i - j - 1] * tem[j];
                }
            }
            return tem[n];
        }
    }

    public static void main(String[] args) {
        L96_不同的二叉搜索树_答案 l96_不同的二叉搜索树 = new L96_不同的二叉搜索树_答案();
        Solution solution = l96_不同的二叉搜索树.new Solution();
        System.out.println(solution.numTrees(3));
    }
}
