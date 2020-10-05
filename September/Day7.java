//TC: O(n)
//SC: O(n) due to hash map for each character in pattern and string in str
class Solution {
    public boolean wordPattern(String pattern, String str) {    
      
        String[] strArr= str.split(" ");
        if(pattern.length()!=strArr.length){
            return false;
        }
        
        HashMap map = new HashMap();
        int i = 0;
        while(i < pattern.length()){
            String string = strArr[i];
            char pat = pattern.charAt(i);
            
            //make entries in both maps if key doesn't exist
            if(!map.containsKey(pat)){
                map.put(pat,string);
            }
            
            if(!map.containsKey(string)){
                 map.put(string,pat);
            }
            
            //if values correponding to both keys in map are not equal, return false
            if(!map.get(pat).equals(string) || !map.get(string).equals(pat)){
                return false;
            }
            i++;
        }
        return true;
    }
}