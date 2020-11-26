//SC: O(1)
//TC: O(26n) = O(n)
class Solution {
    public int longestSubstring(String s, int k) {
        int result = 0;
        //There can be at max 26 unique characters in a string. Get the result for all cases with 1 to 26 unique chars
        for(int i = 1; i <= 26; i++){
            result = Math.max(result, longestSubstringWithNUniqueChars(s, k, i));
        }
        return result;
    }
    
    public int longestSubstringWithNUniqueChars(String s, int k, int numUniqueCharsTarget){
        int i = 0, j = 0, numGreaterThanOrEqualToK = 0, numUniqueChars = 0, result = 0;
        int n = s.length();
        int[] map = new int[26];
        int charVal = 0;
        
        //i is start of window, j is end
        while(j < n){
            charVal = s.charAt(j) - 'a';
            if(map[charVal] == 0){//we encountered a unique char
                numUniqueChars++;
            }
            map[charVal]++;//increment count of char in map
            
            if(map[charVal] == k){//we found a char which occurs at least k times in string
                numGreaterThanOrEqualToK++;
            }
            j++;//expand the sliding window to the right
            
            //till there are more unique chars in the current window that what is required(this required value ranges from 1 to 26), shrink the window from the left
            while(numUniqueChars > numUniqueCharsTarget){
                charVal = s.charAt(i) - 'a';
                //this char is no longer in current window(since we shrink the window) and hence no longer occurs more than or equal to K times in current window
                if(map[charVal] == k){
                    numGreaterThanOrEqualToK--;
                }
                map[charVal]--;//decrement count of char in map
                if(map[charVal] == 0){//this char occured onluy once in window and after shrinking, there is no occurence of this char in new window. Hence we decrease the number of unique chars in current window by 1
                    numUniqueChars--;
                }
                i++;//shrink the sliding window from the left
            }
            
            //if the current window has exactly the same number of unique chars that we require and each of the unique chars occurs at least K times in the window, this length can be a candidate for the solution
            if(numUniqueChars == numUniqueCharsTarget && numUniqueChars == numGreaterThanOrEqualToK){
                result = Math.max(result, j - i);
            }
        }
        return result;
    }
}