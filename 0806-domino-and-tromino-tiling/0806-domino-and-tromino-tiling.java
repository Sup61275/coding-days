class Solution {
    int M= 1000000007;
    int dp[]= new int [10001];
    public int numTilings(int n) {
      Arrays.fill(dp,-1);
      return solve(n);
    }
    int solve(int n){
        if(n==1||n==2){
            return n;
        }
        if(n==3){
            return 5;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=(2*solve(n-1)%M + solve(n-3)%M)%M;
    }
}