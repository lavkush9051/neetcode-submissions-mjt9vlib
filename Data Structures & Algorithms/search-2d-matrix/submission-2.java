class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        int top = 0;
        int bot = rows-1;


        while(top <= bot){
            int roww = (top + bot)/2;
            if(target < matrix[roww][0]){
                bot = roww-1;
            } else if(target > matrix[roww][cols-1]){
                top = roww + 1;
            }else{
                break;
            }
        }
        if(!(top<=bot)){
            return false;
        }

        int row = (top+bot)/2;
        int left = 0;
        int right = cols -1;
        while(left <= right){
            int m = (left + right)/2;
            if(target > matrix[row][m]){
                left = m+1;
            }else if(target < matrix[row][m]){
                right = m-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
