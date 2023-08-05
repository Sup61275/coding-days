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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode previous = null;
        ListNode current = head;
        ListNode nextNode = null;
        int count = 0;

        // Count the number of nodes in the current group
        while (current != null && count < k) {
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
            count++;
        }

        if (count >= k) {
            // Recursively reverse the remaining groups
            head.next = reverseKGroup(current, k);
            return previous;
        } else {
            // If remaining nodes are less than k, reverse them back to their original order
            current = previous;
            previous = null;
            while (current != null) {
                nextNode = current.next;
                current.next = previous;
                previous = current;
                current = nextNode;
            }
            return previous;
        }
    }
}
