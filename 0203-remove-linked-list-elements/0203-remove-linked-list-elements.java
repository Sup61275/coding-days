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
    public ListNode removeElements(ListNode head, int val) {
     if(head==null){
         return head;
     } 
     ListNode current=head;
     ListNode dummy= new ListNode(0);
     dummy.next=head;
     ListNode previous=dummy;
     while(current.next!=null&& current!=null){
         if(current.val==val){
             previous.next=current.next;
             current=current.next;
         }
         else{
             previous=current;
             current=current.next;
            
         }
     }
         if(current.next==null&&current.val==val){
             previous.next=null;
         }
     
      return dummy.next;  
    }
}