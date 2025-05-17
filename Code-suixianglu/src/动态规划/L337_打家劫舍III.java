package 动态规划;

public class L337_打家劫舍III {


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
        public int rob(TreeNode root) {
            int[] ints = robAction(root);
            return Integer.max(ints[0], ints[1]);
        }

        /**
         *
         * @param root
         * @return 返回一个长为2的数组,第一个元素是拿的最大值，第二个元素是不拿的最大值
         */
        public int[] robAction(TreeNode root){
            if (root == null) return new int[2];
            int[] left = robAction(root.left);
            int[] right = robAction(root.right);
            int[] ans = new int[2];
            ans[0] = root.val + left[1] + right[1];
            ans[1] = Integer.max(left[0],left[1]) + Integer.max(right[0], right[1]);
            return ans;
        }
    }
}
