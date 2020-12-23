//SC: O(m*n^2)
//TC: O(9*m*n^2)
class Solution {
     public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][][] dp = new Integer[m][n][n];
        return dfs(grid, m, n, 0, 0, n - 1, dp);
    }
    
    int dfs(int[][] grid, int m, int n, int r, int c1, int c2, Integer[][][] dp) {
        if (r == m)
            return 0; // Reach to bottom row
        if (dp[r][c1][c2] != null)
            return dp[r][c1][c2];//using memory if result was stored earlier
        
        int ans = 0;
        //iterate over all possible moves for robot1 and 2
        //update ans as max(ans, cherries collected)
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nc1 = c1 + i, nc2 = c2 + j;//update columns for both robots
                if (nc1 >= 0 && nc1 < n && nc2 >= 0 && nc2 < n) {//boundary condition
                    ans = Math.max(ans, dfs(grid, m, n, r + 1, nc1, nc2, dp));
                }
            }
        }
        //if both robots arrive at same location, robot1 always collects cherries at that grid, else sum up cherries collected by both robots
        int cherries = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        dp[r][c1][c2] = ans + cherries;//update dp array
        return dp[r][c1][c2];
    }
}
