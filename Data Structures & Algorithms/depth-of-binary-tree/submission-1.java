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
    
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
     Stack<Pair<TreeNode, Integer>> st = new Stack<>();
     int maxDepth = 0;
     st.push(new Pair(root, 1));
     while(!st.empty()) {
        TreeNode node = st.peek().getKey();
        int depth = st.peek().getValue();
        st.pop();
        maxDepth = Math.max(maxDepth, depth);
        if(node.left != null) {
            st.push(new Pair(node.left, depth+1));
        }
        if(node.right != null) {
            st.push(new Pair(node.right, depth + 1));
        }
     }
     return maxDepth;
    }
}
