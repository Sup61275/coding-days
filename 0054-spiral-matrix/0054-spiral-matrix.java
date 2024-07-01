class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer>result=new ArrayList<>();
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        int dir=0;
        while(left <= right && top <= bottom){
            if(dir==0){//constant=top
                 for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;
            }
            else if(dir==1){//constant=right
                for(int i=top;i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;
            }
            else if(dir==2){//constant=bottom
                for(int i=right;i>=left;i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            else if(dir==3){//constant=left
                for(int i=bottom;i>=top;i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
            dir++;
            if(dir==4){
                dir=0;
            }
        }
        return result;
    }
}