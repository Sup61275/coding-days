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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
         if(root1==null&&root2==null){
            return true;
            }
            if(root1==null||root2==null){
               return true;
            }
             getLeaves(root1,list1);
             getLeaves(root2,list2);
             return list1.equals(list2);

    }
     
    private void getLeaves(TreeNode node, ArrayList<Integer>list){
        if(node==null){
            return;
        }
        if(node.left==null&&node.right==null){
            list.add(node.val);
        }
        getLeaves(node.left,list);
        getLeaves(node.right,list);
    }
}

