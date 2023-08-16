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
    public int[] nextLargerNodes(ListNode head) {
        int count=0;
       ListNode current=head;
      
       
       while(current!=null){
           current=current.next;
           count++;
                  } 
                  int[]result=new int[count];
                  current=head;
                  for(int i=0;i<count;i++){
                       ListNode nextNode=current.next;
                       while(nextNode!=null){
                      if(current.val<nextNode.val){
                          result[i]=nextNode.val;
                         break;
                      }else if(current.val>nextNode.val){
                          result[i]=0;
                      }
                     nextNode=nextNode.next;
                      }
                       
                      current=current.next;
                  }
                  

                  return result;
    }
}