class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();

        // row
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(set.contains(board[i][j])) {
                    return false;
                }

                if(board[i][j] != '.') {
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }

        // col
        for(int i = 0; i < board[0].length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(set.contains(board[j][i])) {
                    return false;
                }
                if(board[j][i] != '.') {
                    set.add(board[j][i]);
                }
            }
            set.clear();
        }

        // 3*3 box
        for(int i = 0; i < board.length; i+=3) {
            for(int j = 0; j < board[0].length; j+=3) {
                for(int ii = i; ii < i+3; ii++) {
                    for(int jj = j; jj < j+3; jj++) {
                        if(set.contains(board[ii][jj])){
                            return false;
                        }
                        if(board[ii][jj] != '.') {
                            set.add(board[ii][jj]);
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
