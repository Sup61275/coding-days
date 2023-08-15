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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode current = head;
        int count = 0;
        
        while (current != null) {
            count++;
            current = current.next;
        }
        
        ListNode curr = head;
        int count2 = 1;
        while (curr != null && count2 < k) {
            count2++;
            curr = curr.next;
        }
        
        ListNode firstNode = curr;
        
        ListNode temp = head;
        int tempp = 0;
        while (temp != null && tempp < count - k) {
            tempp++;
            temp = temp.next;
        }
        
        ListNode secondNode = temp;
        
        // Swap the values of the nodes
        int tempVal = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tempVal;
        
        return head;
    }
}
