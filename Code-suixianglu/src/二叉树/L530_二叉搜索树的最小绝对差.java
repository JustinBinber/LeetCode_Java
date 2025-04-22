package 二叉树;
import java.time.chrono.MinguoChronology;

/**
 * @author: yangjiabin
 * @date: 2025/4/21 15:44
 * @desc: 抄的题解，方法比我想的要简单
 */
public class L530_二叉搜索树的最小绝对差 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int pre;
        int ans;

        public int getMinimumDifference(TreeNode root) {
            ans = Integer.MAX_VALUE;
            pre = -1;
            dfs(root);
            return ans;
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (pre == -1) {
                pre = root.val;
            } else {
                ans = Math.min(ans, root.val - pre);
                pre = root.val;
            }
            dfs(root.right);
        }
    }

}
