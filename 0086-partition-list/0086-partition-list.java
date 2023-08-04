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
       
       ArrayList<Integer>list=new ArrayList();
        ArrayList<Integer>list1=new ArrayList();
          ArrayList<Integer>list2=new ArrayList(); 
           for (ListNode current = head; current != null; current = current.next) {
               if(current.val<x){
                   list1.add(current.val);
               }
               else{
                   list2.add(current.val);
               }
          
        }
        list.addAll(list1);
        list.addAll(list2);
        
       ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        for (Integer num : list) {
            current.next = new ListNode(num);
            current = current.next;
        } 
        return dummy.next;
    }
}