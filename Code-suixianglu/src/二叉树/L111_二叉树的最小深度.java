package 二叉树;

public class L111_二叉树的最小深度 {

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
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            return recur(root, root);
        }

        public int recur(TreeNode root, TreeNode treeNode){
            if (treeNode.left == null && treeNode.right == null) return 1;
            int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
            if (treeNode.left != null){
                left = recur(root, treeNode.left);
            }
            if (treeNode.right != null){
                right = recur(root, treeNode.right);
            }

            return Integer.min(left , right) + 1;
        }
    }
}
