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
    public boolean dfs(TreeNode root, int leftRange, int rightRange) {
        if(root == null) return true;

        if(root.val >= rightRange || root.val <= leftRange) {
            return false;
        }

        return dfs(root.left, leftRange, root.val) && dfs(root.right, root.val, rightRange);
    }
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
