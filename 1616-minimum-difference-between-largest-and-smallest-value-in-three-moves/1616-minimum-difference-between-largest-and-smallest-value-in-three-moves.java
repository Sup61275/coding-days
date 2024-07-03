class Solution {
    public int minDifference(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        if(n<=4){
            return 0;
        }
        int result1=nums[n-4]-nums[0];
        int result2=nums[n-1]-nums[3];
        int result3=nums[n-3]-nums[1];
        int result4=nums[n-2]-nums[2];
        return Math.min(result4,Math.min(result3,Math.min(result1,result2)));
       
    }
   
}