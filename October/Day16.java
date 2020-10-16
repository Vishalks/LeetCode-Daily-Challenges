//SC: O(1)
//TC: O(m + n)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)
            return false;
        int n = matrix[0].length;
        if(n == 0)
            return false;
        int row = 0, col = n - 1;//start search from last element in the first row
        
        while(row < m && col >= 0){
            if(matrix[row][col] == target)
                return true;
            //if current element is > target, this means we need to move left in the same row since the row is sorted
            else if(matrix[row][col] > target)
                col--;
            //if current element is < target, move down in the same column since we would find larger numbers there
            else
                row++;
        }
        return false;
    }
}