package 二叉树;

/**
 * @author: yangjiabin
 * @date: 2025/4/21 15:04
 * @desc:
 */
public class L98_验证二叉搜索树 {


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
        public boolean isValidBST(TreeNode root) {
            return recur(root).isBST;
        }

        class minmax{
            int min;
            int max;
            boolean isBST;
            minmax(int min, int max,boolean isBST){
                this.min = min;
                this.max = max;
                this.isBST = isBST;
            }

            minmax() {}
        }

        public minmax recur(TreeNode root){
            if (root == null) return null;

            boolean curIsBST = true;
            int min = root.val;
            int max = root.val;
            minmax leftminmax = recur(root.left);
            minmax righminmax = recur(root.right);

            if (leftminmax != null) {
                curIsBST = root.val > leftminmax.max && leftminmax.isBST;
                min = Math.min(min, leftminmax.min);
                max = Math.max(max, leftminmax.max);
            }
            if (righminmax != null) {
                curIsBST = curIsBST && root.val < righminmax.min && righminmax.isBST;
                min = Math.min(min, righminmax.min);
                max = Math.max(max, righminmax.max);
            }


            return new minmax(min, max, curIsBST);
        }
    }
}
