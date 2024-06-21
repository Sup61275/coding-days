class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
    int n= piles.size();
    int[][]dp= new int[n+1][k+1];
    for(int[] row:dp){
    Arrays.fill(row,0);
    }
    for(int i=1;i<=n;i++){
        for(int coins=0;coins<=k;coins++){
            int sum=0;
            for(int curr_coins=0;curr_coins<=Math.min(piles.get(i-1).size(),coins);curr_coins++){
                if(curr_coins>0)
                sum+=piles.get(i-1).get(curr_coins-1);
                dp[i][coins]=Math.max(dp[i][coins],sum+dp[i-1][coins-curr_coins]);
            }
        }
    }
    return dp[n][k];
    }
}