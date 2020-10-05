//TC: O(n)
//SC: O(n)
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(n == 0)
            return digits;
        int carry = 0;
        int sum = 0;
        
        for(int i = n-1; i >= 0; i--){
            if(i == n-1)
                sum = carry + 1 + digits[i];
            else
                sum = carry + digits[i];
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if(carry == 0)
            return digits;
        
        int[] result = new int[digits.length+1];
        for(int i = digits.length-1; i > 0 ; i--)
            result[i] = digits[i];
        
        result[0] = 1;
        return result;
            
    }
}