// DFS - Bottom-up recursion
// In this problem, performing dfs and maintaining extra coins variable for each node, and adding the absolute value of extra to moves
// after both the left and right recursive calls are completed. In end returning moves.

// Time Complexity : O(n) - going over all nodes
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int moves;

    public int distributeCoins(TreeNode root) {
        // Base case
        if (root == null) {
            return 0;
        }
        // Initialize moves
        moves = 0;
        // Extra
        int extra = dfs(root);
        // Moves
        return moves;
    }

    private int dfs(TreeNode root) {
        // Base case
        if (root == null) {
            // If null return 0
            return 0;
        }
        // Logic
        // Compute the extra coin of current node
        int extra = root.val - 1;
        // Make the left recursive call and get the extra coins from left child and add
        extra += dfs(root.left);
        // Right call
        extra += dfs(root.right);
        // Moves will be abs of extra
        moves += Math.abs(extra);
        // Return extra coins to parent
        return extra;
    }
}