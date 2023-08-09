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
    public ListNode reverseBetween(ListNode head, int left, int right) {
      ListNode dummy= new ListNode(0);
      dummy.next=head;
      ListNode prev= dummy;
      ListNode nextNode= null;
      int pos=1;
      if(head==null||head.next==null){
          return head;
      }
      while(pos<left){
          prev=prev.next;
          pos++;
      }
      ListNode current=prev.next;
      while(current.next!=null && left<right){
          nextNode =current.next;
          current.next=nextNode.next;
          nextNode.next=prev.next;
          prev.next=nextNode;
          left++;

      }
      return dummy.next;
          
      
     
    }
}