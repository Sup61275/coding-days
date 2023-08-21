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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>result=new ArrayList<>();
        
        if(root==null){
            return result;
        }
        
          Sum(root,targetSum,new ArrayList(),result);
return result;

    }
    private void Sum(TreeNode root, int targetSum,List<Integer>list,List<List<Integer>>result){
        
        if(root==null){
            return ;
        }
        list.add(root.val);
          if (root.left == null && root.right == null&& root.val==targetSum) {
              result.add(list);
             }
             
             
             Sum(root.left,targetSum-root.val,new ArrayList(list),result);
             Sum(root.right,targetSum-root.val,new ArrayList(list),result);


    }
}