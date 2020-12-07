//SC: O(1) ignoring space for result
//TC: O(n*n)
class Solution {
    public int[][] generateMatrix(int n) {
        int rowStart = 0, rowEnd = n, colStart = 0, colEnd = n, num = 1;
        int[][] result = new int[n][n];
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int j = colStart; j < colEnd; j++){
                result[rowStart][j] = num;
                num++;
            }
            for(int i = rowStart+1; i < rowEnd; i++){
                result[i][colEnd-1] = num;
                num++;
            }
            if(rowStart < rowEnd && colStart < colEnd){
                for(int j = colEnd-2; j > colStart; j--){
                    result[rowEnd-1][j] = num;
                    num++;
                }
                for(int i = rowEnd-1; i > rowStart; i--){
                    result[i][colStart] = num;
                    num++;
                }
            }
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        return result;
    }
}