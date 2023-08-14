class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode output = new ListNode(0);
        output.val = (l1.val + l2.val) % 10;
        int carry = (l1.val + l2.val) / 10;
        if (l1.next != null || l2.next != null || carry > 0) {
            if (l1.next == null) {
                l1.next = new ListNode(0);
            }
            if (l2.next == null) {
                l2.next = new ListNode(0);
            }
            l1.next.val += carry;
        }
        output.next = addTwoNumbers(l1.next, l2.next);
        return output;
    }
}
