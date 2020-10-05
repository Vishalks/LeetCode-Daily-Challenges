//TC: O(N2)
//SC: O(n)
//

public class Solution {
  public int numTrees(int n) {
    int[] G = new int[n + 1];
    //for the bottom cases, there is only one combination to construct a BST out of a sequence of length 1 (only a root) or nothing (empty tree)
    G[0] = 1;
    G[1] = 1;

    for (int i = 2; i <= n; ++i) {
      for (int j = 1; j <= i; ++j) {
        //we pick a number i out of the sequence as the root, then the number of unique BST with the specified root defined as F(i, n)F(i,n), is the cartesian product of the number of BST for its left and right subtrees
          //To construct an unique BST out of the entire sequence [1, 2, 3, 4, 5, 6, 7] with 3 as the root, which is to say, we construct a subtree out of its left subsequence [1, 2] and another subtree out of the right subsequence [4, 5, 6, 7], and then combine them together (i.e. cartesian product).consider the number of unique BST out of sequence [1,2] as G(2), and the number of of unique BST out of sequence [4, 5, 6, 7] as G(4). For G(n), it does not matter the content of the sequence, but the length of the sequence. Therefore, F(3,7)=G(2)⋅G(4)
        G[i] += G[j - 1] * G[i - j];
      }
    }
    return G[n];
  }
}