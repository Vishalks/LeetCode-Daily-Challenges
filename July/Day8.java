class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int n = nums.length;
        if(n == 0)
            return result;
        
        Arrays.sort(nums);
        int sum = 0, start = 0, end = n-1;
        
        for(int i = 0; i < n-1; i++){
            if(i == 0 || (nums[i] != nums[i-1])){
                sum = -nums[i];
                start = i+1;
                end = n-1;
                while(start < end){
                    if(nums[start] + nums[end] == sum){
                        result.add(new ArrayList(Arrays.asList(nums[i], nums[start], nums[end])));
                        while(start < end && nums[start] == nums[start+1])
                            start++;
                        while(start < end && nums[end] == nums[end-1])
                            end--;
                        start++;
                        end--;
                    }
                    else if(nums[start] + nums[end] < sum){
                        start++;
                    }
                    else if(nums[start] + nums[end] > sum){
                        end--;
                    }
                }
            }
        }
        return result;
    }
}