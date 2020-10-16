//SC: O(1)
//TC: O(nlogn) as we sort both start and end times for each meeting
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length < 1){
            return 0;
        }
        
        int[] start =  new int[intervals.length];
        int[] end =  new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++){
            start[i] =  intervals[i][0];
            end[i] =  intervals[i][1];
        }
        
        //sort both the start and end time arrays
        Arrays.sort(start);
        Arrays.sort(end);
        
        int rooms = 0, endptr = 0;
        
        for(int i = 0; i < intervals.length; i++){
           if(start[i] < end[endptr]) {//there is some new meeting which starts before the current meeting ends. Hence new room will be required
             rooms++;   
           }
            else{
               endptr++;//this meeting can be accomodated within current rooms hence increment and move to end time of next meeting
           }
            
        }
        return rooms;
    }
}