import java.util.HashMap;

public class L71_二叉树的最近公共祖先 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
      }
    class Solution {
        HashMap<TreeNode, Boolean> hasnode;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return Ancestor(root, p, q);
        }
        boolean has_node(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                hasnode.put(root, false);
                return false;
            }
            else if (root == p || root == q) {
                hasnode.put(root, true);
                return true;
            }
            boolean ans = has_node(root.left, p, q) || has_node(root.right, p, q);
            if (ans){
                hasnode.put(root, true);
                return true;
            }
            else {
                hasnode.put(root, false);
                return false;
            }
        }

        TreeNode Ancestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (hasnode.get(root) && hasnode.get(root.left) && hasnode.get(root.right)){
                return root;
            }
            else if ((root == p || root == q) && (hasnode.get(root.left) || hasnode.get(root.right)))
            {
                return root;
            }
            if (Ancestor(root.left, p, q) != null) return Ancestor(root.left, p, q);
            else if(Ancestor(root.right, p, q) != null) return Ancestor(root.right, p, q);
            else return null;
        }
    }
}
