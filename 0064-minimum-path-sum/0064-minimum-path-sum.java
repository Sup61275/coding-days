class Solution {
public int minPathSum(int[][] grid) {
    int [][]memo=new int[201][201];
    for(int[]row:memo){
        Arrays.fill(row,-1);
    }
        return solve(grid,0,0,memo);
    }
    int solve(int[][]grid,int i,int j, int[][]memo){
      int m= grid.length;
      int n=grid[0].length;
      if(i>=m||j>=n){
        return Integer.MAX_VALUE;
      }
      if(memo[i][j]!=-1){
        return memo[i][j];
      }
      if(i==m-1 && j==n-1){
        return grid[i][j];
      }
      
      int right=solve(grid,i,j+1,memo);
    
      int down=solve(grid,i+1,j,memo);
      return memo[i][j]=grid[i][j]+Math.min(right,down);
    }
}