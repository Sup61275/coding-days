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
    public int sumNumbers(TreeNode root) {
       
    
       return Sum(root, 0);
       
    }

    private int Sum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

       sum=sum*10+root.val;

        if (root.left == null && root.right == null) {
         return sum;
            
        }

        int leftsum=Sum(root.left, sum);
        int rightsum=Sum(root.right, sum);
        return leftsum+rightsum;
    }
}
