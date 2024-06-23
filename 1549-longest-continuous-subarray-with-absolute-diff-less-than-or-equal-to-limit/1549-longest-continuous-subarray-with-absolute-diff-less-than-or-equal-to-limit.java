class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n=nums.length;
        int result=0;
        int i=0;
        PriorityQueue<Integer>min_heap= new PriorityQueue<>();
        PriorityQueue<Integer>max_heap= new PriorityQueue<>(Collections.reverseOrder());
        for(int j=0;j<n;j++){
            min_heap.add(nums[j]);
            max_heap.add(nums[j]);
            if(!min_heap.isEmpty()&&!max_heap.isEmpty()&& (max_heap.peek()-min_heap.peek())>limit){
                min_heap.remove(nums[i]);
                max_heap.remove(nums[i]);
                i++;
            }//window size=j-i+1
            result= Math.max(result,j-i+1);
        }
        return result;
    
    }
}