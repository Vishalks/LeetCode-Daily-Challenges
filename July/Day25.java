//TC: O(n) since there are duplicates
//SC: O(1)
class Solution {
  public int findMin(int[] nums) {
    int low = 0, high = nums.length - 1;

    while (low < high) {
      int pivot = low + (high - low) / 2;
      if (nums[pivot] < nums[high])
        high = pivot;
      else if (nums[pivot] > nums[high])
        low = pivot + 1;
      else//since duplciates are allowed, it might be the case that nums[pivot]=nums[high]. This step makes the total time complexity as O(n)
        high -= 1;
    }
    return nums[low];
  }
}