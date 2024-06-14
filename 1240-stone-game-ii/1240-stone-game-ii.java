class Solution {
    public int stoneGameII(int[] piles) {
        int n =piles.length;
        int[][][]memo=new int[2][101][101];
        for(int[][]arr2d:memo){
            for(int[]arr1d:arr2d){
                Arrays.fill(arr1d,-1);
            }
        }
        return solve(piles,1,0,1, memo);
    }
    int solve(int[]piles, int person, int i, int M,int[][][]memo){
        int n =piles.length;
        if(i>=n){
            return 0;
        }
        if (memo[person][i][M] != -1) {
            return memo[person][i][M];
        }
        int stones=0;
       int result = (person == 1) ? -1 : Integer.MAX_VALUE;
       for(int x=1;x<=Math.min(2*M,n-i);x++){
            stones+=piles[i+x-1];
            if(person==1){
                result=Math.max(result,stones+solve(piles,0,i+x,Math.max(x,M),memo));
            }else{
                result=Math.min(result,solve(piles,1,i+x,Math.max(x,M),memo));
            }
        }
        return  memo[person][i][M]=result;
    }
}