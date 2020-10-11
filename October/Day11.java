//SC: O(n)
//TC: O(n*26) where n is because we traverse on entire input. 26 is for inner while loop since there can be atmost 26 characters in the string builder
class Solution {
    public String removeDuplicateLetters(String s) {
       int n = s.length();
        if(n == 1)
            return s;
        
        boolean[] visited = new boolean[26];
        int[] frequency = new int[26];
        StringBuilder sb = new StringBuilder();
        
        for(char ch: s.toCharArray())// count number of occurences of character
            frequency[ch - 'a']++;
        
        for(char ch: s.toCharArray()){
            int index = ch - 'a';
            frequency[index]--;// decrement number of characters remaining in the string to be analysed
            if(visited[index])// if character is already present in stringbuilder stack, continue
                continue;
            
            // if current character is smaller than last character in sb which occurs later in the string again
            // it can be removed and  added later e.g sb = bc remaining string abc then a can remove b and then c
            while(sb.length() > 0 && ch < sb.charAt(sb.length() - 1) && frequency[sb.charAt(sb.length() - 1) - 'a'] != 0){
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(ch);// add current character and mark it as visited
            visited[index] = true;
        }
        return sb.toString();
    }
}