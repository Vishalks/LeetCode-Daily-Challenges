//SC: O(n)
//TC: O(n)
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap();
        int count = 0;
        for(int t: time){
            //iterate over all possible multiples of 60 till 960(since time[i] can be at max 500, this means sum of two songs can be at max 1000. 960 is the closest multiple of 60) to find out if the current t has a complement in the map which was stored in previous iteration
            for(int i = 60; i <= 960; i += 60){
                int complement = i - t;
                //if map contains complement, we can pair two songs that sum upto multiple of 60. So we add occurence count of complement to result. Eg if current t is 60 and map has {120:2}, this means we can make two pairs (60,120) and (60,120) since both 120 duration songs are 2 different songs
                if(map.containsKey(complement)){
                    count += map.get(complement);
                }
            }
            //update count of t in map
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return count;
    }
}