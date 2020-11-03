//SC: O(1)
//TC: O(nlogn)
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        if(n == 0)
            return true;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);//sort acc to start time
        for(int i = 0; i < n - 1; i++){
            //if next interval starts before current interval ends. return false
            if(intervals[i+1][0] < intervals[i][1])
                return false;
        }
        return true;
    }
}