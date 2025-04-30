package 二叉树;

public class L538_把二叉搜索树转换为累加树 {

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
        int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            return recur(root);
        }
        public TreeNode recur(TreeNode treeNode){
            if (treeNode == null) return null;

            TreeNode rightChild = recur(treeNode.right);


            sum += treeNode.val;
            treeNode.val = sum;


            recur(treeNode.left);
            return treeNode;
        }
    }
}
