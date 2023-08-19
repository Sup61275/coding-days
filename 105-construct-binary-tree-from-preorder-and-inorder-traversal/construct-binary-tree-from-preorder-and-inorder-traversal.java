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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inorderStart = 0;
        int inorderEnd = inorder.length - 1; 
        int n = preorder.length; 
        int[] idx = { 0 }; 
        return build(preorder, inorder, idx, inorderStart, inorderEnd, n);
    }

    private TreeNode build(int[] preorder, int[] inorder, int[] idx, int inorderStart, int inorderEnd, int n) {
        if (inorderStart > inorderEnd || idx[0] >= n) {
            return null;
        }
        int element = preorder[idx[0]++];
        TreeNode newNode = new TreeNode(element);
        int position = position(element, inorder, n);
        newNode.left = build(preorder, inorder, idx, inorderStart, position - 1, n);
        newNode.right = build(preorder, inorder, idx, position + 1, inorderEnd, n);
        return newNode;
    }

    private int position(int element, int[] inorder, int n) {
        for (int i = 0; i < n; i++) {
            if (inorder[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
