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
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        List<TreeNode> currNode = new ArrayList<>();
        currNode.add(root);
        
        while (!currNode.isEmpty()) {
            List<Integer> resultList = new ArrayList<>();
            List<TreeNode> nodesToTraverseNext = new ArrayList<>();
            
            for (TreeNode node : currNode) {
                resultList.add(node.val);
                if (node.left != null) {
                    nodesToTraverseNext.add(node.left);
                }
                if (node.right != null) {
                    nodesToTraverseNext.add(node.right);
                }
            }
            
            result.add(resultList);
            currNode = nodesToTraverseNext;
        }
        
        return result;
    }
}
