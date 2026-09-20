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
    int res = Integer.MIN_VALUE;
    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int leftMax = Math.max(dfs(root.left), 0); // if leftMax is -ve then in that case we will not add that value to current node value that's why we are taking max of 0 and left subtree max
        int rightMax = Math.max(dfs(root.right), 0); // if rightMax is -ve then in that case we will not add that value to current node value that's why we are taking max of 0 and right subtree max
        res = Math.max(res, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }

    public int maxPathSum(TreeNode root) {
       dfs(root);
       return res;
    }
}
