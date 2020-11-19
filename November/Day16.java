//SC: O(1)
//TC: O(n)
class Solution {
    public int longestMountain(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {// peak
                
                int left = i - 1;
                while (left > 0 && A[left] > A[left - 1]) {
                    left--;
                }
                
                int right = i + 1;
                while (right < A.length - 1 && A[right] > A[right + 1]) {
                    right++;
                }
                
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }
}