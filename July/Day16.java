//TC: O(logn)
//SC: O(n/2) for function call stack
class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1.0;
        if(n == 1)
            return x;
        if(n == -1)
            return 1 / x;
        
        double pow = myPow(x, n/2);
        
        if(n % 2 == 0){
            return pow * pow;
        }
        else{
            if(n < 0)
                return (1 / x) * pow * pow;
            else
                return x * pow * pow;
        }
    }
}