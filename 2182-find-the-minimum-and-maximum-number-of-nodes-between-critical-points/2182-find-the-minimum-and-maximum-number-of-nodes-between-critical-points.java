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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode current=head.next;
        int idx_track=1;
        ListNode previous=head;
        if(head==null||head.next==null||head.next.next==null){
            return new int[]{-1,-1};
        }
        int []arr= new int[100000];
        int idx=0;
        int []result= new int[2];
        while(current.next!=null){
            if(current.val<previous.val&&current.val<current.next.val){
                arr[idx]=idx_track;
                idx++;
            }else if(current.val>previous.val&&current.val>current.next.val){
                 arr[idx]=idx_track;
                idx++;
            }
            idx_track++;
            previous=current;
            current=current.next;
            
        }
        if(idx<2){
            return new int[]{-1,-1};
        }else if(idx==2){
            result[0]=arr[1]-arr[0];
            result[1]=arr[1]-arr[0];
        }else{
        int min_ele=Integer.MAX_VALUE;
        int max_ele=Integer.MIN_VALUE;
        int min_diff=Integer.MAX_VALUE;
        for(int i=0;i<idx;i++){
            min_ele=Math.min(min_ele,arr[i]);
            max_ele=Math.max(max_ele,arr[i]);
        }
        for(int i=1;i<idx;i++){
           min_diff=Math.min(min_diff,arr[i]-arr[i-1]);
        }
        result[1]=max_ele-min_ele;
        result[0]=min_diff;
        }
       
        return result;

    }
}
