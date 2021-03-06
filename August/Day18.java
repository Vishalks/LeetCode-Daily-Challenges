/*

initialize the current result with all 1-digit numbers, like cur = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9].

BFS:
Each turn, for each x in cur,
we get its last digit y = x % 10.
If y + K < 10, we add x * 10 + y + K to the new list.
If y - K >= 0, we add x * 10 + y - K to the new list.

We repeat this step N - 1 times and return the final result.


Complexity
If K >= 5, time and Space O(N)
If K <= 4, time and space O(2^N)
*/

class Solution {
   public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> cur = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 2; i <= N; ++i) {
            List<Integer> cur2 = new ArrayList<>();
            for (int x : cur) {
                int y = x % 10;
                if (x > 0 && y + K < 10)
                    cur2.add(x * 10 + y + K);
                if (x > 0 && K > 0 && y - K >= 0)
                    cur2.add(x * 10 + y - K);
            }
            cur = cur2;
        }
        return cur.stream().mapToInt(j->j).toArray();
    }
}