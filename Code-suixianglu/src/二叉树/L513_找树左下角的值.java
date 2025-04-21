package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: yangjiabin
 * @date: 2025/3/28 16:04
 * @desc:
 */
public class L513_找树左下角的值 {

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
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            ArrayList<Integer> integers = new ArrayList<>();
            queue.add(root);
            int length = 1;
            while (!queue.isEmpty()) {
                for (int i = 0; i <= length - 1; i++) {
                    TreeNode node = queue.poll();
                    if (i == 0){
                        integers.add(node.val);
                    }
                    if (node.left != null){
                        queue.add(node.left);
                    }
                    if (node.right != null){
                        queue.add(node.right);
                    }

                }
                length = queue.size();
            }
            return integers.get(integers.size() - 1);
        }
    }
}
