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


public class Solution {
    List<Integer> list = new ArrayList<>();

    public int rangeSumBST(TreeNode root, int low, int high) {
        result(root, low, high);
        int sum = 0;
        for (int element : list) {
            sum = sum + element;
        }
        return sum;
    }

    private void result(TreeNode root, int x, int y) {
        if (root == null)
            return;
        if (root.val >= x && root.val <= y) {
            list.add(root.val);
            result(root.left, x, y);
            result(root.right, x, y);
        } else if (root.val > x) {
            result(root.left, x, y);
        } else {
            result(root.right, x, y);
        }
    }
}