class Solution {
    public int numSquares(int n) {
    int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); 
        return solve(n, memo);
    }
    
    private int solve(int n, int[] memo) {
       if(n==0){
        return 0;
       }
       if(memo[n]!=-1){
        return memo[n];
       }
       int minCount= Integer.MAX_VALUE;
       for(int i=1;i*i<=n;i++){
       minCount= Math.min(minCount,1+solve(n-i*i,memo));
       }
       return memo[n]=minCount;
    }
}