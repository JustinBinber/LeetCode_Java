package 二叉树;

public class L101_对称二叉树 {

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
        public boolean isSymmetric(TreeNode root) {
            if (root.left != null && root.right != null) return recur(root.left, root.right);
            else if (root.left == null && root.right == null) {
                return true;
            }
            else return false;
        }
        public boolean recur(TreeNode left, TreeNode right){
            if (left == null && right == null) return true;
            else if (left != null && right != null) {
                if (left.val != right.val) return false;
                return recur(left.left,right.right) && recur(left.right, right.left);
            }
            else return false;
        }

    }
}
