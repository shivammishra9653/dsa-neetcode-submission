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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(pq.size() < k) {
            TreeNode node = q.poll();
            pq.offer(node.val);
            if(node.left != null) {
                q.offer(node.left);
            }
            if(node.right != null) {
                q.offer(node.right);
            }
        }
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(pq.peek() > node.val){
                pq.poll();
                pq.offer(node.val);
            }
            if(node.left != null) {
                q.offer(node.left);
            }
            if(node.right != null) {
                q.offer(node.right);
            }
        }
        System.out.println(pq);
        return pq.peek();
    }
}
