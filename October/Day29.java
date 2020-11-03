//SC: O(1)
//TC: O(n)
class Solution {
    public int maxDistToClosest(int[] seats) {
        int prev = -1, result = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (prev == -1) {//we haven't encountered a filled seat yet till index i, so max would be index i itself
                    result = i;
                }
                //else new result would be max among result, (i - prev)/2
                //i is current index with filled seat and prev is the index before i where a filled seat was encountered previously. Hence (i - prev)/2 will be the index that is at the middle of current index and last index with filled seat and hence max distance from them.
                 else {
                    result = Math.max(result, (i - prev) / 2);
                }
                prev = i;//update index where filled seat was observed previously
            }
        }
        return Math.max(result, seats.length - 1 - prev);//return result
    }
}