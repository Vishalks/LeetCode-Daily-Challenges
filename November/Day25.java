//SC: O(1)
//TC: O(K)
class Solution {
    public int smallestRepunitDivByK(int K) {
        if(K % 2 == 0 || K % 5 == 0)//if K is either 2 or 5, then it's impossible to have a number divisible by K
            return -1;
        
        
        //the remainder will change/unchange from 0,1,2,3... to K-1, therefore the iteration should only be K times and within K iteration, we will find the result if it exists.
        //We can get the remainder directly from N by N % K and move on to the next N by N = N * 10 + 1 but this can lead to an overflow in when N starts increasing and reaches out of the integer limit. Hence, we initialize remainder to 0 and then update it as (remainder * 10 + 1) % K aftere each iteration 
        int remainder = 0;
        for(int i = 1; i <= K; i++){
            remainder = (remainder * 10 + 1) % K;
            if(remainder == 0)
                return i;
        }
        return -1;
    }
}