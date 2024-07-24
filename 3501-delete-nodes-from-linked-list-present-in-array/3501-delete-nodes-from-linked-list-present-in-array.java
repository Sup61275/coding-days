class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer>set= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
       ListNode dummy= new ListNode(-1);
       dummy.next=head;
       ListNode prev=dummy;
       ListNode current=head;
        while(current!=null){
            if(set.contains(current.val)){
                prev.next=current.next;
                
            }else{
                prev=current;
            }
            current=current.next;
        }
        return dummy.next;
    }
}