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
    int idx=0;
    public TreeNode balanceBST(TreeNode root) {
    int []nodes= new int[10001];
    nodes=inorder(root,nodes);
    int n=idx;
    TreeNode newNode= builttree(nodes,0,n-1);
    return newNode;
      
    }
   public int[]inorder(TreeNode root,int[]arr){
    if(root==null){
        return arr;
    }
    inorder(root.left,arr);
    arr[idx++]=root.val;
    inorder(root.right,arr);
    return arr;
    }
    public TreeNode builttree(int[]nodes,int start, int end){
        if(start>end){
        return null;
    }
    int idx=start+(end-start)/2;
    TreeNode new_Node=new TreeNode(nodes[idx]);
    new_Node.left=builttree(nodes,start,idx-1);
    new_Node.right=builttree(nodes,idx+1,end);
    return new_Node;
    }
    
}