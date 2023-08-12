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
        if(head==null||k==0){
            return head;
        }
       ListNode current=head;
       int count=1;
       while(current.next!=null){
           current=current.next;
           count++;
       }
       current.next=head;
       current=head;
       k%=count;
       for(int i=1;i<count-k;i++){
           current=current.next;
       }
       ListNode newHead=current.next;
          current.next=null;
          return newHead;

    }
}

