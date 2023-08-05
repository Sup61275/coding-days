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
    public ListNode partition(ListNode head, int x) {
      ListNode current=head;   
      ListNode leftMain=new ListNode(-1);
      ListNode left=leftMain;
      ListNode rightMain=new ListNode(-1);
      ListNode right=rightMain;
      while(current!=null){
if(current.val<x){
    left.next=new ListNode (current.val);
    left=left.next;
   
}else{
    right.next=new ListNode(current.val);
    right=right.next;
   }
   current=current.next;
      }  
  left.next=rightMain.next;
        return leftMain.next ;
    }
}
