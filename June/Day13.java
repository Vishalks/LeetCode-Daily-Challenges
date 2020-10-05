class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] longest = new int[nums.length];
        int[] next = new int[nums.length];
        int start = Integer.MIN_VALUE, max = 0;
        
        Arrays.fill(next, -1);
        Arrays.sort(nums);
        
        for (int i = nums.length - 1; i >= 0; --i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (longest[j] > longest[i] && nums[j] % nums[i] == 0) {
                    longest[i] = longest[j];
                    next[i] = j;
                }
            }
            ++longest[i];
            if (longest[i] > max) {
                max = longest[i];
                start = i;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while (max-- > 0) {
            res.add(nums[start]);
            start = next[start];
        }
        return res;
    }
}