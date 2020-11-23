//SC: O(n)
//TC: O(n)
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int start = 0, end = 0, counter = 0, len = 0;
        
        //iterate over the entire string
        while(end < s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) == 1)
                counter++;//new char
            end++;//increase the window to the right
            
            //since we want only 2 distinct chars at max, we try shrinking window from left to meet this criteria
            while(counter > 2){
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);
                if(map.get(cTemp) == 0){
                    counter--;
                }
                start++;//update the left boundary of window
            }
            len = Math.max(len, end - start);
        }
        return len;
    }
}