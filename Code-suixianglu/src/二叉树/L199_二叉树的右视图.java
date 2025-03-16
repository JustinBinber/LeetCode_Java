package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L199_二叉树的右视图 {


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
        public List<Integer> rightSideView(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>();
            int size = 0;
            if (root == null) return list;

            queue.add(root);
            size++;
            while (!queue.isEmpty()) {
                size = queue.size();
                for (int i = 0; i <= size - 1; i++) {
                    TreeNode tem = queue.poll();
                    if (tem.left != null){
                        queue.add(tem.left);
                    }
                    if (tem.right != null){
                        queue.add(tem.right);
                    }
                    if (i == size - 1) list.add(tem.val);
                }
            }
            return list;









        }
    }
}
