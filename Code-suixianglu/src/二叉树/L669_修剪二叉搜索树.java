package 二叉树;

import java.awt.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ConcurrentModificationException;

/**
 * @author: yangjiabin
 * @date: 2025/4/30 09:56
 * @desc:
 */
public class L669_修剪二叉搜索树 {

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
        public TreeNode trimBST(TreeNode root, int low, int high) {
            return recur(root, low, high);
        }
        public TreeNode recur(TreeNode root, int low, int high){
            if (root == null) return null;

            if (root.val > low && root.val < high) {
                root.left = recur(root.left, low, high);
                root.right = recur(root.right, low, high);
                return root;
            }
            else if(root.val <= low){
                if (root.val == low) {
                    root.left = null;
                    root.right = recur(root.right, low, high);
                    return root;
                }
                else {
                    // 把右边在范围之内的树返回
                    return recur(root.right, low, high);
                }
            }
            else {
                if (root.val == high){
                    root.right = null;
                    root.left = recur(root.left, low, high);
                    return root;
                }
                else {
                    return recur(root.left, low, high);
                }
            }
        }
    }

}
