//SC: O(1)
//TC: O(n)
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0)
            return 0;
        
        int result = 0;
        for(int i = 0; i < timeSeries.length - 1; i++){
            if(timeSeries[i] + duration <= timeSeries[i+1])//if no  overlap between attack times
                result += duration;
            else
                result += timeSeries[i+1] - timeSeries[i];//in case where Ashe is in poisoned state and before the state ends, Teemo attacks again
        }
        return result + duration;//add duration for last attack in result
    }
}