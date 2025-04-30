package 二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class L501_二叉搜索树中的众数 {

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
        int last = Integer.MIN_VALUE;
        int maxTime = 0;
        int curTime = 0;
        Deque<Integer> deque = new LinkedList<Integer>();
        public int[] findMode(TreeNode root) {
            recur(root);
            int[] ans = new int[deque.size()];
            int size = deque.size();
            for (int i = 0; i <= size - 1; i++) {
                ans[i] = deque.pollFirst();
            }
            return ans;
        }
        public void recur(TreeNode treeNode){
            if (treeNode == null) return;
            recur(treeNode.left);

            if (last == Integer.MIN_VALUE){
                last = treeNode.val;
                curTime++;
                maxTime++;
                deque.add(treeNode.val);
            }
            else if (last == treeNode.val) {
                curTime++;
                if (curTime > maxTime){
                    maxTime = curTime;
                    deque.clear();
                    deque.add(treeNode.val);
                }
                else if (curTime == maxTime) deque.add(treeNode.val);
            }
            else {
                last = treeNode.val;
                curTime = 1;

                if (curTime == maxTime) deque.add(treeNode.val);
            }

            recur(treeNode.right);
        }
    }

    public static void main(String[] args) {

        L501_二叉搜索树中的众数 l501_二叉搜索树中的众数 = new L501_二叉搜索树中的众数();
        Solution solution = l501_二叉搜索树中的众数.new Solution();
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null));
    }
}
