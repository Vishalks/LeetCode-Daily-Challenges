class Solution {
    public String reverseWords(String s) {
        int i = s.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0){
            if(s.charAt(i) == ' '){
                i--;
                continue;
            }
            int end = i;
            while(i>= 0 && s.charAt(i) != ' '){
               i--; 
            }
            sb.append(s.substring(i+1, end+1));
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}