package 二叉树;

public class L654_最大二叉树 {

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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            int max = findMax(nums, 0, nums.length - 1);
            TreeNode treeNode = new TreeNode(nums[max]);
            recur(nums, 0, nums.length - 1, max, treeNode);
            return treeNode;
        }

        public void recur(int[] nums, int left, int right, int max_idx, TreeNode root){
            if (left == right){
//                if (max_idx > left) root.left = new TreeNode(nums[left]);
//                else root.right = new TreeNode(nums[left]);
                return;
            }

            if (left <= max_idx - 1){
                int lmax = findMax(nums, left, max_idx - 1);
                TreeNode lroot = new TreeNode(nums[lmax]);
                root.left = lroot;
                recur(nums, left, max_idx - 1, lmax, lroot);
            }

            if (right >= max_idx + 1){
                int rmax = findMax(nums, max_idx + 1, right);
                TreeNode rroot = new TreeNode(nums[rmax]);
                root.right = rroot;
                recur(nums, max_idx + 1, right, rmax, rroot);

            }
        }

        public int findMax(int[] arr, int left, int right){
            int max = Integer.MIN_VALUE;
            int max_idx = 0;
            for (int i = left; i <= right; i++) {
                if (arr[i] >= max) {
                    max = arr[i];
                    max_idx = i;
                }
            }
            return max_idx;
        }
    }
}
