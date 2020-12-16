//SC: O(1) ignoring space for result
//TC: O(n)
class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;//2 pointers on extremes of array
        
        for (int p = n - 1; p >= 0; p--) {
            //if absolute value of left pointer is greater than that at right, put its square at index p and increase left pointer by 1
            if (Math.abs(A[left]) > Math.abs(A[right])) {
                result[p] = A[left] * A[left];
                left++;
            }
            //if absolute value of right pointer is greater than that at left, put its square at index p and decrease right pointer by 1
            else {
                result[p] = A[right] * A[right];
                right--;
            }
        }
        return result;
    }
}