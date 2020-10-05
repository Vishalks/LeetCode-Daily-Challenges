class Solution {
    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length())
            return false;
        if(t.equals(s) || s.length() == 0)
            return true;
        int j = 0;
        int i = 0;
        int tLen = t.length();
        int sLen = s.length();
        boolean found = false;
        while(i < sLen && j < tLen){
            if(s.charAt(i) != t.charAt(j)){
                while(j < tLen && (s.charAt(i) != t.charAt(j)))
                    j++;
            }
            if(i == sLen - 1 && j < tLen && s.charAt(i) == t.charAt(j))//if s ends with s[i]=t[j], match found
                return true;
            i++;
            j++;
        }
        return false;
    }
}