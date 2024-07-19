class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map_row = new HashMap<>();
        Map<Integer, Integer> map_col = new HashMap<>();
        
        // Find the minimum element in each row
        for (int i = 0; i < m; i++) {
            int minRow_element = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                minRow_element = Math.min(minRow_element, matrix[i][j]);
            }
            map_row.put(i, minRow_element);
        }
        
        // Find the maximum element in each column
        for (int j = 0; j < n; j++) {
            int maxCol_element = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                maxCol_element = Math.max(maxCol_element, matrix[i][j]);
            }
            map_col.put(j, maxCol_element); 
        }
        
        Map<Integer, int[]> get_row = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int[] row = new int[n];
            for (int j = 0; j < n; j++) {
               row[j] = matrix[i][j]; 
            }
            get_row.put(i, row);
        }
        
        Map<Integer, int[]> get_col = new HashMap<>(); 
        for (int j = 0; j < n; j++) {
            int[] col = new int[m];
            for (int i = 0; i < m; i++) {
                col[i] = matrix[i][j];
            }
            get_col.put(j, col); 
        }

        for (int i = 0; i < m; i++) {
            int minRowEle = map_row.get(i);
            for (int j = 0; j < n; j++) { // Loop through columns to find the column index
                if (matrix[i][j] == minRowEle) {
                    int maxColEle = map_col.get(j);
                    if (minRowEle == maxColEle) {
                        result.add(maxColEle);
                    }
                }
            }
        }

        return result;
    }
}
