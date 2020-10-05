//TC: O(number of possible paths * m * n)
//SC: O(number of possible paths * m * n) if we consider stack for recursive function calls
class Solution {
    
    int result = 0;
    int countOfZeroes = 0;
    
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int origRow = 0;
        int origCol = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] >= 0){//since we are guaranteed we will get only 1, we also count it in countOfZeroes
                    countOfZeroes++;
                    if(grid[i][j] == 1){
                        origRow = i;//get row and col where 1 occurs
                        origCol = j;
                    }
                }
            }
        }
        
        if(countOfZeroes == 0)
            return 0;
        
        dfs(grid, origRow, origCol, m, n, 1);//call dfs with row and col of 1
        return result;
    }
    
    public void dfs(int[][] grid, int i, int j, int m, int n, int zeroCount){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1)//boundary conditions
            return;
        
        if(zeroCount == countOfZeroes && grid[i][j] == 2){//we have visted exactly all 0's only once, hence increment result and return
            result++;
            return;
        }
        
        zeroCount++;//increment count of zeroes in this path
        int temp = grid[i][j];//store the value at i and j since we are going to change it in next step to mark it as visited
        grid[i][j] = -1;//mark i j as visited
        
        //call dfs on all neighbors
        dfs(grid, i-1, j, m, n, zeroCount);
        dfs(grid, i, j-1, m, n, zeroCount);
        dfs(grid, i+1, j, m, n, zeroCount);
        dfs(grid, i, j+1, m, n, zeroCount);
        
        //again put the original value back at i and j since we would need it while exploring a different path than the current one
        grid[i][j] = temp;
        return;
    }
}