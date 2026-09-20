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
    public TreeNode dfs(int[] preorder, HashMap<Integer, Integer> indMap, int l, int r) {
        if(l > r) return null;

        int rootVal = preorder[ind++];
        TreeNode root = new TreeNode(rootVal);
        int mid = indMap.get(rootVal);
        root.left = dfs(preorder, indMap, l, mid-1);
        root.right = dfs(preorder, indMap, mid+1, r);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> indMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            indMap.put(inorder[i], i);
        }
        return dfs(preorder, indMap, 0, inorder.length - 1);
    }
}
