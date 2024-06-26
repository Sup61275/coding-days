class Solution {
   public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return false;
    }
    
    int n = matrix.length;
    int m = matrix[0].length;
    int start = 0;
    int end = m * n - 1;
    
    while (start <= end) {
        int mid = start + (end - start) / 2;
        int row = mid / m;
        int col = mid % m;
        
        if (matrix[row][col] == target) {
            return true;
        } else if (matrix[row][col] < target) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    
    return false;
}

}