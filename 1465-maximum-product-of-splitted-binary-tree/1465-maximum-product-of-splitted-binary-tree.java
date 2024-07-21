class Solution {
    int mod = 1000000007;
    long totalSum = 0;
    long maxproduct = 0;
    public int maxProduct(TreeNode root) {
        totalSum=treeSum(root);
        helper(root);
        
        return (int) (maxproduct % mod);
    }
    public long treeSum(TreeNode root){
        if(root==null){
            return 0;
        }
        long leftSum=treeSum(root.left);
        long rightSum=treeSum(root.right);
        return root.val+leftSum+rightSum;
    }
    public long helper(TreeNode root){
        if(root==null){
            return 0;
        }
        long leftSum=helper(root.left);
        long rightSum=helper(root.right);
        long subTreeSum=leftSum+rightSum+root.val;
        long product=subTreeSum*(totalSum-subTreeSum);
        maxproduct=Math.max(maxproduct,product);
        return subTreeSum;
    }

    
    
}

