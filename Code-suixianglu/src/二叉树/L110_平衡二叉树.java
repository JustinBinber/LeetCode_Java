package 二叉树;

public class L110_平衡二叉树 {

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
        public class depth{
            int max;
            boolean isBalance;
            depth(int max, boolean isBalance){
                this.max = max;
                this.isBalance = isBalance;
            }
        }

        public boolean isBalanced(TreeNode root) {


            return recur(root).isBalance;

        }

        public depth recur(TreeNode root){
            if (root == null) return new depth(0,true);

            depth leftDepth = recur(root.left);
            depth rightDepth = recur(root.right);

            int max = Integer.max(leftDepth.max, rightDepth.max);

            return new depth(max + 1, leftDepth.isBalance && rightDepth.isBalance && Math.abs(leftDepth.max - rightDepth.max) <= 1);
        }
    }
}
