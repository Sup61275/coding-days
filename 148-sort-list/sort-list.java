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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode mid = findMid(head);
        ListNode right = mid.next;
       mid.next = null;
       ListNode Sortedleft = sortList(head);
       ListNode Sortedright = sortList(right);
        return merge(Sortedleft, Sortedright);
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        if (right == null) {
            return left;
        }
        if (left == null) {
            return right;
        }
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
             
                left = left.next;
            } else {
                temp.next = right;
         
                right = right.next;
            }
            temp=temp.next;
        }
      if(left != null) {
            temp.next = left;
            left=left.next;
          
          
        }else if (right != null) {
            temp.next = right;
            right=right.next;
          
           
        }
        return dummy.next;
    }
}
