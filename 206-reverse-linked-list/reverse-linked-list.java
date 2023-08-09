class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current=head;
        ListNode dummy= new ListNode(0);
        ListNode previous= dummy;
        dummy.next=head;
        ListNode nextNode =null;
        if(head==null||head.next==null){
            return head;
        }
        while(current.next!=null){
            nextNode= current.next;
            current.next=nextNode.next;
            nextNode.next=previous.next;
            previous.next=nextNode;
        }
        return dummy.next;
    }
}

    
