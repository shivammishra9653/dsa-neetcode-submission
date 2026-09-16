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
    class Pair {
        TreeNode node;
        int min;
        int max;
        public Pair(TreeNode node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }
    public boolean isValidBST(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            if(p.node.val <= p.min || p.node.val >= p.max) {
                return false;
            }
            if(p.node.left != null) {
                q.offer(new Pair(p.node.left, p.min, p.node.val));
            }
            if(p.node.right != null) {
                q.offer(new Pair(p.node.right, p.node.val, p.max));
            }
        }
        return true;
    }
}
