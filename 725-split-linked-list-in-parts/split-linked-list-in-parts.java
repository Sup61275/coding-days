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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode current=head;
        ListNode dummy=new ListNode(0);
        ListNode prev=dummy;
        dummy.next=head;
        int count=0;
        while(current!=null){
            current=current.next;
            count++;
        }
        ListNode []array=new ListNode[k];
       
        int len=count/k;
        int mod=count%k;
        int i=0;
        while(i<k){
            array[i]=head;
            for(int j=0;j<len;j++){
                prev=head;
                head=head.next;

            }if(i<mod){
                prev=head;
                head=head.next;
            }
            prev.next=null;
            i++;
        }
        return array;


    }
}