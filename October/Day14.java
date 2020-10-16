//SC: O(n)
//TC: O(n)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        
        //answer is max(if we start robbing from 0th to n-2, from 1st to n-1th house)
        return Math.max(helper(nums, 0, n-1), helper(nums, 1, n));
    }
    
    public int helper(int[] nums, int start, int end){
        int[] dp = new int[nums.length];
        
        //in case of we rob house 0 to n-2
        if(start == 0){
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
        }
        //in case of we rob house 1 to n-1
        else{
            dp[1] = nums[1];
        }
        
        //similar to house robber problem: https://leetcode.com/problems/house-robber
        //for which house to rob next, we take
        //max(amount robbed so far just before the current house + current rob amount, amount robbed so far)
        for(int i = 2; i < end; i++)
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        
        return dp[end-1];
    }
}