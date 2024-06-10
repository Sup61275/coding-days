
class Solution  {
    public int rob(int[] nums){
        int n =nums.length;
        int dp[]= new int[n];
        Arrays.fill(dp,-1);
        return solve(nums,0,dp);
    }
    int solve(int[]nums, int idx, int[]dp){
        int n =nums.length;
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int notTake=solve(nums,idx+1,dp);
        int take=0;
        take=nums[idx]+solve(nums,idx+2,dp);
        return dp[idx]= Math.max(take, notTake);
    }
   
}
