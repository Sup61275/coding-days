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
    public ListNode mergeNodes(ListNode head) {
        ListNode current = head.next; 
        ListNode prev = head;
        int sum = 0;

        while (current != null) {
            if (current.val != 0) {
                sum += current.val; 
                current = current.next;
            } else {
                prev.val = sum;
                sum = 0;
                prev.next = current.next;
                current = current.next;
                prev = current;
            }
        }

        return head;
    }
}