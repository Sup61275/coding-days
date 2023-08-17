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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int elements:nums){
            set.add(elements);
        }
        int count=nums.length;
        while(head!=null&&head.next!=null){
            if(set.contains(head.val)&&set.contains(head.next.val)){
                count--;
               
            }
             head=head.next;

        }
        
        return count;
    }
}
