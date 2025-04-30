package 二叉树;

public class L235_二叉搜索树的最近公共祖先 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if ( (root.val > p.val && root.val < q.val) || (root.val > q.val && root.val < p.val) ){
                return root;
            }
            else if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            else if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            else return root;
        }
    }
}
