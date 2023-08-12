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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        int length = getLength(head);
        k %= length;  // Adjust k to be within the length of the list
        
        if (k == 0) {
            return head;
        }
        
        ListNode newHead = findNewHead(head, length - k);
        ListNode newTail = findNewTail(newHead);
        
        newTail.next = head;
        head = newHead;
        return head;
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
    
    private ListNode findNewHead(ListNode head, int newHeadIndex) {
        for (int i = 1; i < newHeadIndex; i++) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }
    
    private ListNode findNewTail(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}

