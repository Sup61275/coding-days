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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode current=list1;
        ListNode currentb=list1;
        ListNode dummy=list2;
        while(currentb.next!=null&& b-- >=0){
            currentb=currentb.next;
            
        }
        while(dummy.next!=null){
            dummy=dummy.next;
        }
        dummy.next=currentb;
        while(current.next!=null&& a-->1){
            current=current.next;
          
        }
        current.next=list2;
       
        return list1;
    }
}