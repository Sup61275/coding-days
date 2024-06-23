class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long min_position= -1;
        long max_position= -1;
        long result=0;
        long culprit_idx=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxK || nums[i]<minK){
                culprit_idx=i;
            }
            if(nums[i]==minK){
                min_position=i;
            }
            if(nums[i]==maxK){
                max_position=i;
            }
            long smaller_position=Math.min( min_position, max_position);
            long temp=smaller_position-culprit_idx;
            result+=(temp<=0)?0:temp;
        }
        return result;
    
    }
}