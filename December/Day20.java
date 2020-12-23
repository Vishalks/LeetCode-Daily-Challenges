//SC: O(1)
//TC: O(n)
class Solution {
    public String decodeAtIndex(String S, int K) {
        long N = 0L;
        int i = 0;
        //calculate the length of decoded string
        while(N < K){
            N = Character.isDigit(S.charAt(i)) ? N*(S.charAt(i) - '0') : N + 1;
            i++;
        }
        
        i--;//go to last char in S
        
        //start from end of decoded string
        while (true){
            //if S.charAt(i) = d is a digit, then N = N / d before repeat and K = K % N is what we want
            if (Character.isDigit(S.charAt(i))) {
                N /= S.charAt(i) - '0';
                K %= N;
            }
            //if S.charAt(i) = d is a character, we return c if K == 0 or K == N
            else if (K % N == 0)
                return "" + S.charAt(i);
            else
                N--;
            i--;//go toprev char in string S
        }
    }
}