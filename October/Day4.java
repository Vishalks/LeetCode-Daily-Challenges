//SC: O(1)
//TC: O(nlogn)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> (a[0] - b[0]));//sort intervals acc to their start time
        int n = intervals.length, count = 0;
        
        for(int i = 0; i < n-1; i++){
            //check if first interval can be merged in second or vice versa
            if((intervals[i][0] <= intervals[i+1][0] && intervals[i][1] >= intervals[i+1][1])
              || (intervals[i+1][0] <= intervals[i][0] && intervals[i+1][1] >= intervals[i][1])){
                //if merge is possible, we always update the start and end times of next interval only(i+1) since we are traversing all intervals only once
                intervals[i+1][0] = Math.min(intervals[i][0], intervals[i+1][0]);
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
                count++;//increment count of merges
            }
        }
        return n - count;//return total intervals - total merges
    }
}