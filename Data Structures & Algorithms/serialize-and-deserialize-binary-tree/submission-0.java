/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode node = q.poll();
            if(node.left == null) {
                sb.append(",#");
            } else {
                sb.append("," + node.left.val);
                q.offer(node.left);
             }

             if(node.right == null) {
                sb.append(",#");
             } else {
                sb.append("," + node.right.val);
                q.offer(node.right);
             }
            }
        }
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;

        String[] str = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        for(int i = 1; i < str.length; i = i+2) {
            TreeNode node = q.poll();
            if(!str[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(str[i]));
                q.offer(node.left);
            }
            if(i+1 < str.length && !str[i+1].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(str[i+1]));
                q.offer(node.right);
            }
        }
        return root;
    }
}
