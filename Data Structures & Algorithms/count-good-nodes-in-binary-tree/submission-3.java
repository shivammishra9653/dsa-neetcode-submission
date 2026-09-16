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
    public int goodNodes(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair(root, Integer.MIN_VALUE));
        int res = 0;
        while(!q.isEmpty()) {
            TreeNode node = q.peek().getKey();
            int maxVal = q.peek().getValue();
            q.poll();
            if(node.val >= maxVal) {
                res++;
                maxVal = node.val;
            }
            if(node.left != null) {
                q.offer(new Pair(node.left, maxVal));
            }
            if(node.right != null) {
                q.offer(new Pair(node.right, maxVal));
            }
        }
        return res;
    }
}
