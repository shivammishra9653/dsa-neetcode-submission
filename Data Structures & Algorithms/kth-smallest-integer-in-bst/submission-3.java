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
    public void inorder(TreeNode root, int[] arr) {
        if(root == null) return;
        inorder(root.left, arr);
        arr[0]--;
        if(arr[0] == 0) {
            arr[1] = root.val;
            return;
        }
        inorder(root.right, arr);
    }
    public int kthSmallest(TreeNode root, int k) {
       int[] arr = new int[2];
       arr[0] = k;
       inorder(root, arr);
       return arr[1];
    }
}
