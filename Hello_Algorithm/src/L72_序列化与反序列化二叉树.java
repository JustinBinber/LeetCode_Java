import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class L72_序列化与反序列化二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//代码不对
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList();
            StringBuilder s = new StringBuilder();
            if (root == null) return "";
            queue.add(root);
            while (!queue.isEmpty()){
                root = queue.poll();
                if (root != null){
                    s.append(Integer.toString(root.val) + '_');
                    queue.add(root.left);
                    queue.add(root.right);
                }
                else {
                    s.append("#_");
                }
            }
            return s.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (Objects.equals(data, "")) return null;
            String[] s = data.split("_");
            TreeNode[] treeNodes = new TreeNode[(data.length() + 1) / 2];
            for (int i = 0; i < (data.length() + 1) / 2 - 1; i++){
                if (!Objects.equals(s[i], "#")) treeNodes[i] = new TreeNode(Integer.parseInt(s[i]));
            }
            for (int i = 0; i < (data.length() + 1) / 2 - 1; i++){
                if (Objects.equals(s[i], "#")) continue;
                if (!Objects.equals(s[i], "#")) {
                    if (i <= (data.length() + 1) / 4 - 1){
                        treeNodes[i].left = treeNodes[2 * i + 1];
                        treeNodes[i].right = treeNodes[2 * i + 2];
                    }
                    else{
                        treeNodes[i].left = null ;
                        treeNodes[i].right = null;
                    }

                }
            }
            return treeNodes[0];


        }
    }
    public static void main(String[] args) {
        L72_序列化与反序列化二叉树 obj = new L72_序列化与反序列化二叉树();
        Codec codec = obj.new Codec();

        // 创建二叉树
        TreeNode root = obj.new TreeNode(1);
        root.left = obj.new TreeNode(2);
        root.right = obj.new TreeNode(3);
        root.left.left = null;
        root.left.right = null;
        root.right.left = obj.new TreeNode(4);
        root.right.right = obj.new TreeNode(5);

        // 序列化
        String serializedData = codec.serialize(root);
        System.out.println("Serialized Tree: " + serializedData);

        // 反序列化
        TreeNode deserializedRoot = codec.deserialize(serializedData);
        System.out.println("Deserialized Tree Root Value: " + deserializedRoot.val);
    }


}
