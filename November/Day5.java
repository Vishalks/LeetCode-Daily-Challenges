//SC: O(1)
//TC: O(n)
class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenCount = 0, oddCount = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return Math.min(oddCount, evenCount);
    }
}