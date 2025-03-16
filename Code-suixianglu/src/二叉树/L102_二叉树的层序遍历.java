package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L102_二叉树的层序遍历 {

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
        public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return ans;

        queue.add(root);
        int cur_size = 1;

        while(queue.isEmpty() != true){
            list = new ArrayList<Integer>();
            for(int i = 0; i <= cur_size - 1; i++){
                TreeNode tem = queue.poll();
                if(tem.left != null){
                queue.add(tem.left);
                 }
                 if(tem.right != null){
                queue.add(tem.right);
            }
                 list.add(tem.val);
         }
        cur_size = queue.size();
        ans.add(list);

 }
 return ans;
}
    }
}
