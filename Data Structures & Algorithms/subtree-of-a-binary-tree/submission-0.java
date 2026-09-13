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

class Solution { 
    public boolean subTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if(root == null || subRoot == null || (root.val != subRoot.val)) {
            return false;
        }
        return subTree(root.left, subRoot.left) && subTree(root.right, subRoot.right);
    } 
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q = new ArrayDeque<>();

        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.val == subRoot.val && subTree(node, subRoot)) {
                return true;
            }
            if(node.left != null) {
                q.offer(node.left);
            }
            if(node.right != null){
                q.offer(node.right);
            }
        }
        return false;
    }
}
