package 二叉树;

public class L222_完全二叉树的节点个数 {

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
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            TreeNode tem = root;
            int deep = 0;
            while (tem.left != null){
                tem = tem.left;
                deep++;
            }

            return recur(root, 0, deep);

        }

        public int recur(TreeNode root, int headDeep, int deep){
            if (root == null) return 0;

            TreeNode right = root.right;
            int rightDeep = headDeep;

            while (right != null){
                right = right.left;
                rightDeep++;
            }

            if (rightDeep == deep){
                return (2 << deep - headDeep - 1) + recur(root.right, headDeep + 1, deep);
            }

            return (2 << rightDeep - headDeep - 1) + recur(root.left, headDeep + 1, deep);
        }
    }

    public static void main(String[] args) {
        System.out.println(1<<0);
    }
}
