//SC: O(n)
//TC: O(n2)
public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<Integer>();
        int fact = 1;
        int l = k - 1;//since indices start from 0
        int index = 0;//initialize
        
        //calculate factorial s well as add all digits from 1 to n in the list
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        
        
        for (int i = 0; i < n; i++) {
            fact /= (n - i);//get number of permuatations possible by keeping (i+1) elements as fixed and permuting others. So, if we keep first element(1) out of 4 as fixed, no -of permutations= 24/(4)=6. This is true since remaining 3 digits can be permuted in 6 ways.
            index = (l / fact);//index of the number in the list that would be the next in permutation sequence
            sb.append(num.remove(index));//this step takes O(n). hence, total TC = O(n2)
            l -= index * fact;
        }
        
        return sb.toString();
    }
}
//for detailed explanation: https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)