//SC: O(n)
//TC: O(n)
public class Solution {
    public int findPairs(int[] nums, int k) {

        int result = 0;

        HashMap <Integer,Integer> counter = new HashMap();
        for (int n: nums) {
            counter.put(n, counter.getOrDefault(n, 0)+1);
        }


        for (int key: counter.keySet()) {
            if (k > 0 && counter.containsKey(key + k)) {
                result++;
            } else if (k == 0 && counter.get(key) > 1) {
                result++;
            }
        }
        return result;
    }
}