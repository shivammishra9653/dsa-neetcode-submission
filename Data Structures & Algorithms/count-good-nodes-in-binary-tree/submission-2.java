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
    public int preorder(TreeNode root, int max) {
        if(root == null) return 0;
       int res = root.val >= max ? 1 : 0;
       max = Math.max(max, root.val);

       res += preorder(root.left, max);
        res += preorder(root.right, max);
        return res;
    }
    public int goodNodes(TreeNode root) {
        
        return preorder(root, root.val);
    }
}
