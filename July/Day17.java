class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // freq map
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        // bucket sort on freq. Array of List of Integers
        List<Integer>[] bucket = new List[nums.length + 1];//we take +1 since max frequency can be nums.length(all same numbers) and we start freq from 0
        
        for (int i = 0; i < bucket.length; i++)
            bucket[i] = new ArrayList();
        
        for (int key : freq.keySet()) {
            bucket[freq.get(key)].add(key);
        }
        
        // gather result
        List<Integer> res = new ArrayList();
        for (int i = bucket.length - 1; i >= 0; i--) {
            res.addAll(bucket[i]);
            if (res.size() >= k)
                break;
        }
        int[] result = new int[k];
        for(int i = 0; i < res.size(); i++)
            result[i] = res.get(i);
        
        return result;
    }
}