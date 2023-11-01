/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        int count = length(head);
        return build_tree(head, 0, count - 1);
    }
   
    private int length(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }
    
    private TreeNode build_tree(ListNode head, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        ListNode current = head;
        
        for (int i = start; i < mid; i++) {
            current = current.next;
        }
        
        TreeNode root = new TreeNode(current.val);
        
        root.left = build_tree(head, start, mid - 1);
        root.right = build_tree(current.next, mid + 1, end);
        
        return root;
    }
}
