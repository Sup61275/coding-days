class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
   if(nums.length<3)return 0;
   int count=0;
   int currentCount=0;
   for(int i=2;i<nums.length;i++){
    if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
        currentCount++;
        count+=currentCount;
        }else{
            currentCount=0;
        }

        
    }
    return count;
    }
   
}