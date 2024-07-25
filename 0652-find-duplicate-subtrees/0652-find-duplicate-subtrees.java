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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode>result= new ArrayList<>();
        Map<String,Integer>map= new HashMap<>();
        helper(root,result,map);
        return result;
    }
    String helper(TreeNode root,List<TreeNode>result,Map<String,Integer>map){
    if(root==null){
        return "N";
    }
    String uniqueIdentity=root.val+","+helper(root.left,result,map)+","+helper(root.right,      result,map);
    map.put(uniqueIdentity,map.getOrDefault(uniqueIdentity,0)+1);
    if(map.get(uniqueIdentity)==2){
        result.add(root);
    }

        
        return uniqueIdentity;
    }
}