class Solution {
  
    public int minDifficulty(int[] jd, int d) {
        int n=jd.length;
        if(d>jd.length){
        return -1;
        }
        int memo[][]=new int[d+1][n];
        for(int[]row:memo){
            Arrays.fill(row,-1);
        }
        return solve(jd,d,0,memo);
    }
    private int solve(int[]arr,int d ,int idx, int[][] memo){
        if(d==1){
            int maxD=0;
            for(int i=idx;i<arr.length;i++){
                maxD=Math.max(arr[i],maxD);
            }
            return maxD;
        }
        if(memo[d][idx]!=-1){
            return memo[d][idx];
        }
        int maxD=0;
        int Minresult=Integer.MAX_VALUE;
        for(int i=idx;i<=arr.length-d;i++){
            maxD=Math.max(arr[i],maxD);
           int result=maxD+solve(arr,d-1,i+1,memo);
           Minresult=Math.min(result,Minresult);
        }
        return  memo[d][idx]= Minresult;
        
    }
} 