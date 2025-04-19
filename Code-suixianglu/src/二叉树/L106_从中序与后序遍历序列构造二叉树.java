package 二叉树;

import java.util.HashMap;

public class L106_从中序与后序遍历序列构造二叉树 {

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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i <= inorder.length - 1; i++) {
                hashMap.put(inorder[i], i);
            }
            TreeNode root = new TreeNode(postorder[postorder.length - 1]);
            recur(hashMap, root, inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
            return root;
        }

        public void recur(HashMap<Integer, Integer> hashMap, TreeNode root, int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
            if (inLeft >= inRight || inLeft < 0 || inRight > inorder.length - 1) return;

            int rootVal = postorder[postRight];

            Integer indexIn = hashMap.get(rootVal);
            int leftLen = indexIn - inLeft;
            int rightLen = inRight - indexIn;

            int post1 = postLeft + leftLen - 1;
            int post2 = post1 + rightLen;

            if (leftLen != 0) root.left = new TreeNode(postorder[post1]);
            if (rightLen != 0)root.right = new TreeNode(postorder[post2]);

            recur(hashMap, root.left, inorder, postorder, inLeft, indexIn - 1, postLeft, post1);
            recur(hashMap, root.right, inorder, postorder, indexIn + 1, inRight, post1 + 1, post2);



        }
    }

    public static void main(String[] args) {
        L106_从中序与后序遍历序列构造二叉树 l106_从中序与后序遍历序列构造二叉树 = new L106_从中序与后序遍历序列构造二叉树();
        Solution solution = l106_从中序与后序遍历序列构造二叉树.new Solution();
        solution.buildTree(new int[]{2, 1}, new int[]{2, 1});
    }
}
