//SC: O(1)
//TC: O(n)
class Solution {
    public int maxPower(String s) {
        int result = Integer.MIN_VALUE;
        int n = s.length();
        if(n == 1)
            return 1;
        for(int i = 0; i < n-1; i++){
            int len = 1;
            //if we get same consecutive char as the current char, increase len and pointer i
            while(i < n-1 && s.charAt(i) == s.charAt(i+1)){
                len++;
                i++;
            }
            result = Math.max(result, len);//udpate result
            //if len = 1, this means no consecutive char was found equal to current char and hence reset i to i-1
            if(len > 1)
                i--;
        }
        return result;
    }
}