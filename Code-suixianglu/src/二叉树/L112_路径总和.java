package 二叉树;

/**
 * @author: yangjiabin
 * @date: 2025/3/28 16:15
 * @desc:
 */
public class L112_路径总和 {

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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            return recur(root, targetSum);
        }
        
        public boolean recur(TreeNode root, int targetSum){
            if(root == null) return false;
            if(root.left == null && root.right == null && root.val == targetSum){return true;};

            boolean left = recur(root.left, targetSum - root.val);
            boolean right = recur(root.right, targetSum - root.val);
            return left || right;
        }
    }
}
