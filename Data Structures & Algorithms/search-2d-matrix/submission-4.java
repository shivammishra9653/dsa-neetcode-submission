class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bot = matrix.length - 1;
        int col = matrix[0].length - 1;
        int row = 0;

        while(top <= bot) {
            row = (top+bot)/2;
            if(target < matrix[row][0]) {
                bot--;
            } else if(target > matrix[row][col]) {
                top++;
            } else {
                break;
            }
        }
        if(top > bot) {
            return false;
        }
        int l = 0;
        int r = col;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(matrix[row][mid] == target) {
                return true;
            } else  if(matrix[row][mid] > target) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }
}
