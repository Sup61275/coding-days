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
    public int diameterOfBinaryTree(TreeNode root) {
        return diam(root);
    }
    int diam(TreeNode root){
        if(root==null){
            return 0;
        }
        int dia1=diam(root.left);
        int dia2=diam(root.right);
        int dia3=height(root.left)+height(root.right);
        return Math.max(dia3,Math.max(dia1,dia2));
    }
    int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
}