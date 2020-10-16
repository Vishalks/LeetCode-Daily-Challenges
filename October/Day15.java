//SC: O(1)
//TC: O(n)
class Solution {
    //we firstly reverse all the elements of the array. Then, reversing the first k elements followed by reversing the rest n-k elements gives us the required result.
     public void rotate(int[] nums, int k) {
         int n = nums.length;
         k %= nums.length;
         reverse(nums, 0, n - 1);
         reverse(nums, 0, k - 1);
         reverse(nums, k, n - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}