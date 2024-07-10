class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Integer> row_map = new HashMap<>();
        Map<Character, Integer> column_map = new HashMap<>();
        Map<Character, Integer> box_map = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            row_map.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    row_map.put(board[i][j], row_map.getOrDefault(board[i][j], 0) + 1);
                }
            }
            for (int itr : row_map.values()) {
                if (itr > 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            column_map.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    column_map.put(board[j][i], column_map.getOrDefault(board[j][i], 0) + 1);
                }
            }
            for (int itr : column_map.values()) {
                if (itr > 1) {
                    return false;
                }
            }
        }
  
        for (int row = 0; row < 9; row += 3) {
        for (int col = 0; col < 9; col += 3) {
            box_map.clear();
            for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] != '.') {
                    box_map.put(board[i][j], box_map.getOrDefault(board[i][j], 0) + 1);
                    }
                }
            }
            for (int itr : box_map.values()) {
                if (itr > 1) {
                return false;
                }
            }
        }
        
    }
    return true;
}
}



      

