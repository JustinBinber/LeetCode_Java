package 二叉树;

/**
 * @author: yangjiabin
 * @date: 2025/4/30 11:02
 * @desc:
 */
public class L108_将有序数组转换为二叉搜索树 {

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
        public TreeNode sortedArrayToBST(int[] nums) {
            return recur(nums, 0, nums.length - 1);
        }
        public TreeNode recur(int[] nums, int left, int right){
            if (left > right || left >= nums.length || right < 0) return null;

            int mid = (left + right) >> 1;
            TreeNode treeNode = new TreeNode(nums[mid]);
            treeNode.left = recur(nums, left, mid - 1);
            treeNode.right = recur(nums, mid + 1, right);
            return treeNode;
        }
    }
}
