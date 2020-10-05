//SC: O(1001) = O(1)
//TC: O(n) since we iterate over all trips
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001];
        
        //Process all trips, adding passenger count to the start location, and removing it from the end location. After processing all trips, a positive value for the specific location tells that we are getting more passengers; negative - more empty seats.
        for(int[] t: trips){
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }
        
        //scan all stops and check if we ever exceed our vehicle capacity
        int i = 0;
        while(i <= 1000){
            if(capacity >= 0){
                capacity -= stops[i];
            }
            i++;
        }
        
        return capacity >= 0;
    }
}