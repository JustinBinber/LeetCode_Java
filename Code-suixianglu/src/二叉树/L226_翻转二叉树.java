package 二叉树;

public class L226_翻转二叉树 {

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
        public TreeNode invertTree(TreeNode root) {
            recur(root);
            return root;
        }
        public void recur(TreeNode treeNode){
            if (treeNode == null) return;
            TreeNode left = treeNode.left;
            TreeNode right = treeNode.right;
            treeNode.left = right;
            treeNode.right = left;
            recur(left);
            recur(right);
        }
    }
}
