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
    ListNode leftHead=new ListNode (-1);
     ListNode rightHead=new ListNode (-1);
      ListNode left=leftHead;
          ListNode right=rightHead;
     while(current!=null){
         
      if(current.val<x){
         left.next=current;
         left=left.next;
      }else{
          right.next=current;
          right=right.next;
      }
      current=current.next;
     }
        right.next=null;
      left.next=rightHead.next;
     return leftHead.next;
    }

}
