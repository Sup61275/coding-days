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
        ListNode firstNode=head;
        ListNode secondNode =current;

        int count = 1;
        
        while (current != null) {
           
            if(count<k){
            firstNode=firstNode.next;
            }
            if(count>k){
                secondNode=secondNode.next;
            }
            count++;
           current=current.next;
        }
      
        
        // Swap the values of the nodes
        int tempVal = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tempVal;
        
        return head;
    }
}
