/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Set<String> visited = new HashSet<String>();
    
    public void cleanRoom(Robot robot) {
        backtracking(robot, new int[]{0,0}, 0);
    }
    
    private void backtracking(Robot robot, int[] pos, int p) {
        String position = pos[0] + "," + pos[1];
        if (visited.contains(position)) {
            return;
        }
        else {
            visited.add(position);
            robot.clean();
            for (int i = 0; i < 4; i++) {
                int newP = (p + i) % 4;
                if (!robot.move()) {
                    robot.turnRight();
                    continue;
                }
                int[] newPos = {pos[0] + directions[newP][0], pos[1] + directions[newP][1] };
                backtracking(robot, newPos, newP);
                robot.turnRight(); //backtracking; move the robot to its original position and facing direction
                robot.turnRight();
                robot.move();
                robot.turnLeft(); //here equals to 3 turnright(); two of them are for backtracking
            }
        }  
    }
}