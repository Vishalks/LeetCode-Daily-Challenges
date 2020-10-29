//SC: O(n)
//TC: O(n)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList();
        int n = nums.length;
        if(n == 0)
            return result;
        
        for(int i = 0; i < n; i++){
            int j = i;
            while(j < n - 1 && nums[j + 1] - nums[j] == 1){
                j++;
            }
            if(i == j){
                result.add(String.valueOf(nums[i]));
            }
            else{
                result.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[j]));
            }
            i = j;
        }
        return result;
    }
}