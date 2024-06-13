class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n =satisfaction.length;
        Arrays.sort(satisfaction);
        int[][]memo= new int[n][n+1];
        for(int[]row:memo){
            Arrays.fill(row,-1);
        }
        return solve(satisfaction,0,1,memo);
         
    }
    int solve(int[]satisfaction, int idx, int time, int[][]memo){
        int n= satisfaction.length;
        if(idx>=n){
            return 0;
        }
        if(memo[idx][time]!=-1){
            return memo[idx][time];
        }
        int notTake=solve(satisfaction,idx+1,time,memo);
        int coEff=satisfaction[idx]*time;
        int take= coEff+solve(satisfaction,idx+1,time+1,memo);
        return memo[idx][time]= Math.max(notTake,take);
    }
}