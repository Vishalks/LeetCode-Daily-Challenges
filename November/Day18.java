//SC: O(length of input - no of merges)
//TC: O(nlogn)
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int merges = 0;
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));//sort according to start time
        for(int i = 0; i < n-1; i++){
            if(intervals[i+1][0] <= intervals[i][1]){//if start of next interval falls between start and end of current interval - overlap condition
                intervals[i+1][0] = intervals[i][0];//set start and end of new merged interval accordingly
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
                merges++;
                intervals[i][0] = -1;//denote this interval has been merged into some interval
            }
        }
        
        int[][] result = new int[n-merges][2];
        int j = 0;
        for(int i = 0; i < n; i++){
            if(intervals[i][0] != -1){
                result[j] = intervals[i];
                j++;
            }
        }
        return result;
    }
}