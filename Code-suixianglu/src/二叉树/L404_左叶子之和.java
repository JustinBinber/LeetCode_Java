package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: yangjiabin
 * @date: 2025/3/28 14:48
 * @desc:
 */
public class L404_左叶子之和 {


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
        public int sumOfLeftLeaves(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Object> list = new ArrayList<>();
            queue.add(root);
            list.add(false);

            int ans = 0;
            int len = queue.size();


            while (!queue.isEmpty()) {
                for (int i = 0; i <= len - 1; i++) {
                    TreeNode poll = queue.poll();
                    if (i == 0 ) {
                        if (poll.left == null && poll.right == null && list.get(i).equals(true)) {
                            ans += poll.val;
                        }
                    }
                    if (poll.left != null) {
                        queue.add(poll.left);
                        list.add(true);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                        list.add(false);
                    }

                }
                list.subList(0, len).clear();
                len = queue.size();
            }
            return ans;
        }
    }
}
