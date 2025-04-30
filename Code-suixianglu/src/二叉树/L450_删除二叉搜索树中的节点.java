package 二叉树;

public class L450_删除二叉搜索树中的节点 {

    public static class TreeNode {
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
        public TreeNode deleteNode(TreeNode root, int key) {
            TreeNode ans = root;
            TreeNode father = null;
            while (root != null){
                if (root.val == key){
                    TreeNode hebing = hebing(root.left, root.right);
                    if (ans == root) return hebing;
                    else {
                        if (father.left == root){
                            father.left = hebing;
                        } else if (father.right == root) {
                            father.right = hebing;
                        }
                        return ans;
                    }
                }
                else if(root.val < key){
                    father = root;
                    root = root.right;
                }
                else {
                    father = root;
                    root = root.left;
                }
            }
            return ans;
        }

        public TreeNode hebing(TreeNode leftTreeNode, TreeNode rightTreeNode){
            if (leftTreeNode == null) return rightTreeNode;
            if (rightTreeNode == null) return leftTreeNode;

            TreeNode root = rightTreeNode;
            while (rightTreeNode.left != null){
                rightTreeNode = rightTreeNode.left;
            }
            rightTreeNode.left = leftTreeNode;
            return root;
        }


    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);  // 注意：6 的左子节点为 null，右子节点为 7
        L450_删除二叉搜索树中的节点 l450_删除二叉搜索树中的节点 = new L450_删除二叉搜索树中的节点();
        Solution solution = l450_删除二叉搜索树中的节点.new Solution();
        solution.deleteNode(root, 3);
    }



}
