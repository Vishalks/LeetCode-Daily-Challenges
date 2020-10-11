//SC: O(1)
//TC: O(nlogn)
class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n <= 1)
            return n;
        
        //if end points are same, sort by start point in ascending order else sort by which balloon ends first
        Arrays.sort(points, (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int count = 1;
        int currentEnd = points[0][1];//initialize current end to be end of first balloon
        
        for(int i = 1; i < n; i++){
            //if current end falls between start and end diameter coordinate of ith balloon, continue
            if(points[i][0] <= currentEnd && points[i][1] >= currentEnd)
                continue;
            //else we would need another arrow to burst this ith balloon. update current end as end of this balloon
            else{
                count++;
                currentEnd = points[i][1];
            }
        }
        return count;
    }
}