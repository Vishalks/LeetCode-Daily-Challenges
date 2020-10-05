//SC: O(1)
//TC: O(n)
public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDist = Integer.MIN_VALUE;
        int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);
        
        for (int i = 1; i < arrays.size(); i++) {
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);
            maxDist = Math.max(maxDist, Math.max(currMax - min, max - currMin));
            max = Math.max(max, currMax);
            min = Math.min(min, currMin);
        }
        return maxDist;
    }
}