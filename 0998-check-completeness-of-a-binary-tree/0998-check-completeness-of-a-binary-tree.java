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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode>q= new LinkedList<>();
        q.offer(root);
        boolean past=false;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                TreeNode currNode=q.poll();
                if(currNode==null){
                    past=true;
                }else{
                    if(past==true){
                        return false;
                    } 
                    q.offer(currNode.left);
                    q.offer(currNode.right);
                
                }
            }
        }
        return true;
    }
}