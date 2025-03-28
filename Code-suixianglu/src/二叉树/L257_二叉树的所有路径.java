package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class L257_二叉树的所有路径 {

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
        List<String> ans = new ArrayList<>();
        public List<String> binaryTreePaths(TreeNode root) {
            recur(root, String.valueOf(root.val));
            return ans;
        }

        public void recur(TreeNode root, String path){
            if (root == null) {
                return;
            }
            if (root.left == null && root.right ==null) ans.add(path);

            String val = "";
            if (root.left != null){

                val = "->" + root.left.val;
            }
            recur(root.left, path + val);

            val = "";

            if (root.right != null){

                val = "->" + root.right.val;
            }

            recur(root.right, path + val);
        }

        class Solution1 {
            public List<String> binaryTreePaths(TreeNode root) {
                List<String> paths = new ArrayList<String>();
                constructPaths(root, "", paths);
                return paths;
            }

            public void constructPaths(TreeNode root, String path, List<String> paths) {
                if (root != null) {
                    StringBuffer pathSB = new StringBuffer(path);
                    pathSB.append(Integer.toString(root.val));
                    if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                        paths.add(pathSB.toString());  // 把路径加入到答案中
                    } else {
                        pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                        constructPaths(root.left, pathSB.toString(), paths);
                        constructPaths(root.right, pathSB.toString(), paths);
                    }
                }
            }
        }


    }
}
