class Solution {
    int memo[][]= new int[1001][1001];
    public int findLongestChain(int[][] pairs) {
     Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[0]));
     for(int[]row:memo){
        Arrays.fill(row,-1);
     }
        return solve(pairs,0,-1);
    }
    private int solve(int[][]pairs, int idx, int prevIdx){
        int n =pairs.length;
        if(idx==n){
            return 0;
        }
        if(prevIdx!=-1&&memo[idx][prevIdx]!=-1){
            return memo[idx][prevIdx];
        }
        int notTake= solve(pairs,idx+1,prevIdx);
        int take=0;
        if(prevIdx==-1 || pairs[prevIdx][1]<pairs[idx][0]){
            take=1+solve(pairs,idx+1,idx);
        }
        if(prevIdx!=-1)
        memo[idx][prevIdx]=Math.max(take,notTake);
        return Math.max(take,notTake);
    }
    
}