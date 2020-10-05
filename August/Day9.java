class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        
        //add all the rotten oranges to the queue
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
            }
        }
        
        int x = 0;
        int y = 0;
        int count = 0;
        
        //Apply BFS and increase the count at each bfs iteration
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int i = 0; i < size; i++){
                int[] rotten = q.poll();
                for(int[] d: dir){
                  x = rotten[0] + d[0];
                  y = rotten[1] + d[1];
                  if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1)//out of bounds or either rotten or no orange
                      continue;
                    
                    grid[x][y] = 2;//mark the fresh orange as rotten and add it to queue
                    q.add(new int[]{x, y});
                }
            }
        }
        
        for(int i = 0; i < m; i++)
            for(int j = 0 ; j < n; j++)
                if(grid[i][j] == 1)//if fresh orange is still in the grid, not possible to have all oranges rotten. Return -1;
                    return -1;
        if(count != 0)
            return count-1;
        return count;
    }
}