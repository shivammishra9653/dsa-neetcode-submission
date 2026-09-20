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
    int ind = 0;
    public TreeNode dfs(int[] preorder, int inorder[], int l, int r) {
        if(l > r) return null;

        int rootVal = preorder[ind++];
        TreeNode root = new TreeNode(rootVal);
        int mid = -1;
        for(int i = l; i <= r; i++) {
            if(inorder[i] == rootVal) {
                mid = i;
                break;
            }
        }
        root.left = dfs(preorder, inorder, l, mid-1);
        root.right = dfs(preorder, inorder, mid+1, r);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, inorder.length - 1);
    }
}
