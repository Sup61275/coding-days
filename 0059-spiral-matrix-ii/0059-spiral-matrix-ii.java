class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int dir=0;
        int [][]matrix= new int[n][n];
        int num=1;
        
        while(left <= right && top <= bottom){
            if(dir==0){//constant=top
                 for(int i=left;i<=right;i++){
               matrix[top][i]=num++;
            }
            top++;
            }
            else if(dir==1){//constant=right
                for(int i=top;i<=bottom;i++){
               matrix[i][right]=num++;
            }
            right--;
            }
            else if(dir==2){//constant=bottom
                for(int i=right;i>=left;i--){
                   matrix[bottom][i]=num++;
                }
                bottom--;
            }
            else if(dir==3){//constant=left
                for(int i=bottom;i>=top;i--){
                  matrix[i][left]=num++;
                }
                left++;
            }
            dir++;
            if(dir==4){
                dir=0;
            }
        }
        return matrix;
    }
}