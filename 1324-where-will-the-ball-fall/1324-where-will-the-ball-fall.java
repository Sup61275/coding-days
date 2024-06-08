class Solution {
    public int[] findBall(int[][] grid) {
       int m =grid.length;
       int n = grid[0].length;
       int[] ballArr= new int[n];
       for(int j=0;j<n;j++){
        ballArr[j]= findBallPath(grid,j);
       }
       return ballArr;
    }
    private int findBallPath(int[][] grid, int col){
        int m =grid.length;
        int n = grid[0].length;
        int currentCol=col;
        for(int i=0;i<m;i++){
            if(grid[i][currentCol]==1){
                if(currentCol == n - 1 || grid[i][currentCol + 1] == -1){
                    return -1;
                }
                currentCol++;
            }else if(grid[i][currentCol]==-1){
                if(currentCol == 0 || grid[i][currentCol - 1] == 1){
                    return -1;
                }
                currentCol--;
            }
            
        }
        return currentCol;
    }
}