package 二叉树;

public class L104_二叉树的最大深度 {

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
        public int maxDepth(TreeNode root) {
            return recur(root);
        }
        public int recur(TreeNode treeNode){
            if (treeNode == null) return 0;
            int left = recur(treeNode.left);
            int right = recur(treeNode.right);
            return Integer.max(left, right) + 1;
        }
    }
}
