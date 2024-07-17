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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
       List<TreeNode>temp=new ArrayList<>();
       Set<Integer>set= new HashSet<>();
       for(int num:to_delete){
        set.add(num);
       }
       if(!set.contains(root.val)){
        temp.add(root);
       }
       helper(root,temp,set);
       return temp;

      
    }
    private TreeNode helper(TreeNode root, List<TreeNode>temp,Set<Integer>set){
        if(root==null){
        return null;
       }
       root.left=helper(root.left,temp,set);
       root.right=helper(root.right,temp,set);
       if(set.contains(root.val)){
        if(root.left!=null){
            temp.add(root.left);
        }
        if(root.right!=null){
            temp.add(root.right);
        }
        return null;
       }
       return root;
       
     
    }
   
}