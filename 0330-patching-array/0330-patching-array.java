class Solution {
    public int minPatches(int[] nums, int n) {
      int len=nums.length;
      //SUAS=smallest unobtainable sum
      long SUAS=1;
      int patches=0;
      int i=0;
      while(SUAS<=n){
        if(i<len && nums[i]<=SUAS){
            SUAS+=nums[i];
            i++;
        }else{
            SUAS+=SUAS;
            patches++;
        }

      }
      return patches;
    }
}