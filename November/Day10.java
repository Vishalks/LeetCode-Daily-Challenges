//SC: O(1)
//TC: O(n^2)
/*Compare the i th and n - i - 1 th in a row. If the values are not the same, but we swap and flip, nothing will change. So if they are same, we toggle both, otherwise we do nothing*/
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
        return A;
    }
}