class Solution {
    public String addBinary(String a, String b) {
        if(a == null || b == null || a.isEmpty() || b.isEmpty()){
            return "";
        }
        int m = a.length();
        int n = b.length();
        int maxLen = Math.max(m, n);
        StringBuilder sb = new StringBuilder();
        
        //this is just to make the string operations faster. this code works even when we operate directly over string
        StringBuilder aSb = new StringBuilder(a);
        StringBuilder bSb = new StringBuilder(b);
        
        if(maxLen > m){
            for(int i = 0; i < maxLen-m; i++)
                aSb.insert(0, '0');
        }
        if(maxLen > n){
            for(int i = 0; i < maxLen-n; i++)
                bSb.insert(0, '0');
        }
        int carry = 0;
        for(int i = maxLen-1; i >= 0; i--){
            int b1 = aSb.charAt(i) - '0';
            int b2 = bSb.charAt(i) - '0';
            int sum = b1 + b2 + carry;
            if(sum <= 1){//can be either 0 or 1
                sb.insert(0, (char)(b1+b2+carry + '0'));
                carry = 0;
            }
            else if(sum == 2 || sum == 3){
                carry = 1;
                if(sum == 2)
                    sb.insert(0, '0');
                else
                    sb.insert(0, '1');
            }
        }
        if(carry == 1)
            sb.insert(0, '1');
        return sb.toString();
    }
}