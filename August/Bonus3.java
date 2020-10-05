//TC: O(m*n)
//SC: O(m*n)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    int m = maze.length;
    int n = maze[0].length;
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[m][n];
    int[][] directions = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    queue.add(start);
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      if (cur[0] == destination[0] && cur[1] == destination[1]) {
        return true;
      }
        
      if (visited[cur[0]][cur[1]])
        continue;
        
      visited[cur[0]][cur[1]] = true;
      // Check for all possible directions
      for (int[] dir: directions) {
        int x = cur[0], y = cur[1];
        while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
          x += dir[0];
          y += dir[1];
        }
        // Back to validate point.
        x -= dir[0];
        y -= dir[1];
        // Adding new start point.
        queue.add(new int[] {x, y});
      }
    }
    return false;
  }
}