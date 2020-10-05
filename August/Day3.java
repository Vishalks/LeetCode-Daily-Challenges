//TC: O(n)
//SC: O(1)
class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if(n == 0)
            return true;
        int start = 0;
        int end = n-1;
        while(start <= end){
            if(!Character.isAlphabetic(s.charAt(start)) && !Character.isDigit(s.charAt(start))){
                start++;
            } else if(!Character.isAlphabetic(s.charAt(end)) && !Character.isDigit(s.charAt(end))){
                end--;
            } else if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            } else{
                start++;
                end--;
            }        }
        return true;
    }
}