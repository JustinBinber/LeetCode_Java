package 二叉树;

import javax.xml.validation.Validator;

/**
 * @author: yangjiabin
 * @date: 2025/4/22 10:19
 * @desc:
 */
public class L236_二叉树的最近公共祖先 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            boolean leftFind = findTarget(root.left, p.val, q.val);
            boolean rightFind = findTarget(root.right, p.val, q.val);
            if (leftFind && rightFind) return root;
            else if (leftFind){
                if (root.val == p.val || root.val == q.val) return root;
                else return lowestCommonAncestor(root.left, p, q);
            }
            else if (rightFind){
                if (root.val == p.val || root.val == q.val) return root;
                else return lowestCommonAncestor(root.right, p, q);
            }
            else return root;
        }

        public boolean findTarget(TreeNode root, int k, int m) {
            if (root == null) return false;

            return root.val == k || root.val == m || findTarget(root.left, k, m) || findTarget(root.right, k, m);
        }
    }
}
