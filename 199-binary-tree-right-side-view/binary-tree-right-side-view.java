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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        rightSideView(root, result, 0);
        return result;
    }
    
    private void rightSideView(TreeNode node, List<Integer> result, int depth) {
        if (node == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(node.val);
        }
        
        rightSideView(node.right, result, depth + 1);
        rightSideView(node.left, result, depth + 1);
    }
}
