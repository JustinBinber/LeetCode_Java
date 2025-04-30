package 二叉树;

public class L701_二叉搜索树中的插入操作 {

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
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            recur(root, val);
            return root;
        }
        public void recur(TreeNode root, int val){
            if (val > root.val) {
                if (root.right != null) recur(root.right, val);
                else root.right = new TreeNode(val);
            } else {
                if (root.left != null) recur(root.left, val);
                else root.left = new TreeNode(val);
            }
        }
    }
}
