class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int i=0,j=0;
        int len_count=Integer.MAX_VALUE;
        int sum=0,trailSum=0;
        for(int k=0;k<nums.length;k++){
            trailSum+=nums[k];
        }
        if(trailSum<target){
            return 0;
        }
        while(j<n){
           sum+=nums[j];
           while(sum>=target){
            len_count=Math.min(len_count,j-i+1);
            sum-=nums[i];
            i++;
           }
            j++;
           
        }
        return len_count;
    }
}