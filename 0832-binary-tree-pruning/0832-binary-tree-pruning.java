class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return dfsHelper(root);
    }
    TreeNode dfsHelper(TreeNode root){
        if(root==null){
            return null;
        }
        root.left=dfsHelper(root.left);
        root.right=dfsHelper(root.right);
        if(root.val==0 && root.left==null && root.right==null){
            return null;

        }
        
        return root;
    }
}