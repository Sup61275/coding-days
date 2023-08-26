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
    int result;
    public int sumNumbers(TreeNode root) {
       
      
        Sum(root, 0);
        return result;
       
    }

    private void Sum(TreeNode root, int sum) {
        if (root == null) {
            return ;
        }

       sum=sum*10+root.val;

        if (root.left == null && root.right == null) {
            result+=sum;
         return;
            
        }

       Sum(root.left, sum);
        Sum(root.right, sum);
       
    }
}
