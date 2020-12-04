//SC: O(1)
//TC: O(sqrt(n))
class Solution {
    public int kthFactor(int n, int k) {
        int sqrt = (int)Math.sqrt(n);
        //iterate from 1 till sqrt(n) to get the kth divisor
        for(int i = 1; i <= sqrt; i++) {
            if(n % i == 0 && --k == 0) {
                return i;
            }
        }
        
        //if k is greater than number of divisors till sqrt(n), iterate from sqrt(n) till 1 to get (n / i) as kth divisor
        for(int i = sqrt; i >= 1; i--){
            if(n % i == 0 && i*i != n && --k == 0) {//skip when n is perfect square
                return n / i;
            }
        }
        return -1;
    }
}