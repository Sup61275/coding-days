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
    private int maxSum = Integer.MIN_VALUE; // Initialize maxSum with the smallest possible value

    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxSum;
    }

    private int findMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // Recursively calculate the maximum path sum for the left and right subtrees
        int leftMax = Math.max(findMaxPathSum(root.left), 0);
        int rightMax = Math.max(findMaxPathSum(root.right), 0);
        
        // Update maxSum with the maximum of (current node + left subtree) + right subtree
        maxSum = Math.max(maxSum, root.val + leftMax + rightMax);
        
        // Return the maximum path sum that includes either the left or right subtree
        return root.val + Math.max(leftMax, rightMax);
    }
}
