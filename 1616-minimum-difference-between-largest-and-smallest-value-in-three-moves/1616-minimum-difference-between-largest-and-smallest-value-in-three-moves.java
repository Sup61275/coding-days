class Solution {
    public int minDifference(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        if(n<=4){
            return 0;
        }
        int[]copy= new int[n];
        for(int i=0;i<n;i++){
            copy[i]=nums[i];
        }
        int[]copy1= new int[n];
        for(int i=0;i<n;i++){
            copy1[i]=nums[i];
        }
        int[]copy2= new int[n];
        for(int i=0;i<n;i++){
            copy2[i]=nums[i];
        }
        int result1=case1(nums);
        int result2=case2(copy);
        int result3=case3(copy1);
        int result4=case4(copy2);
        return Math.min(result4,Math.min(result3,Math.min(result1,result2)));
       
    }
    int case1(int[] nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[n-1]=nums[0];
            nums[n-2]=nums[0];
            nums[n-3]=nums[0];
        }
        Arrays.sort(nums);
        return nums[n-1]-nums[0];
    }
    int case2(int[] nums){
         int n=nums.length;
        for(int i=0;i<n;i++){
            nums[0]=nums[n-1];
            nums[1]=nums[n-1];
            nums[2]=nums[n-1];
        }
        Arrays.sort(nums);
        return nums[n-1]-nums[0];
    }
    int case3(int[] nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[0]=nums[n-3];
            nums[1]=nums[n-3];
            nums[n-1]=nums[n-3];
        }
        Arrays.sort(nums);
        return nums[n-1]-nums[0];
    }
    int case4(int[] nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[0]=nums[2];
            nums[n-2]=nums[3];
            nums[n-1]=nums[3];
        }
        Arrays.sort(nums);
        return nums[n-1]-nums[0];
    }
}