//SC: O(n) to store in treemap as well as result 
//TC: O(nlogn) due to TreeMap
public class Solution {

  public int[] findRightInterval(int[][] intervals) {
    TreeMap<Integer, Integer> starts = new TreeMap<>();
    int res[] = new int[intervals.length];
    
    //insert key as start of interval and value as index in treemap. Treemap is sorted acc to key hence all intervals will be sorted according to their start times
    for (int i = 0; i < intervals.length; i++) {
      starts.put(intervals[i][0], i);
    }
      
    
    //for every interval, get the minimum interval which is just larger than the end time of current interval  
    for (int i = 0; i < intervals.length; i++) {
      Map.Entry<Integer, Integer> pos = starts.ceilingEntry(intervals[i][1]);
      res[i] = pos == null ? -1 : pos.getValue();//if pos is null, no such interval exists so add -1 else add value(index of the interval whose start time is just greater than or equal to current interval) from the key,value pair obtained from ceilingEntry function
    }
    return res;
  }
}