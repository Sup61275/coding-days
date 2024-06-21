class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][]memo=new int[2001][1001];
        for(int[]row:memo){
            Arrays.fill(row,-1);
        }
        return solve(piles,k,0,memo);

    }
    int solve(List<List<Integer>> piles, int k,int index, int memo[][]){
        int n =piles.size();
        if (index >= n|| k == 0) {
        return 0;
        }
        if(memo[k][index]!=-1){
            return memo[k][index];
        }
        int notTake_money =solve(piles,k,index+1,memo);
        int curr_money=0;
        int take_money=0;
        for(int j = 0; j < piles.get(index).size() && j < k; j++){
            curr_money+=piles.get(index).get(j);
            take_money=Math.max(take_money,curr_money+solve(piles,k-j-1,index+1,memo));
        }
       return memo[k][index]=Math.max(take_money,notTake_money); 
    }
}