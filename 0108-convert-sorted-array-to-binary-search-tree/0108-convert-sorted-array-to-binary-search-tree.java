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
    public TreeNode sortedArrayToBST(int[] nums) {
        return tree(nums, 0, nums.length - 1);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }

    private TreeNode tree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = tree(nums, left, mid - 1);
        root.right = tree(nums, mid + 1, right);
        
        return root;
    }
}
