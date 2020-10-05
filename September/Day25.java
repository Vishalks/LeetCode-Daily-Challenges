class Solution {
    public char findTheDifference(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[] a = new int[26];
        
        for(int i = 0; i < sLen; i++){
            a[s.charAt(i) - 'a']--;
            a[t.charAt(i) - 'a']++;
        }
        a[t.charAt(tLen-1) - 'a']++;
        
        for(int i = 0; i < tLen; i++)
            if(a[t.charAt(i)  -'a'] != 0)
                return t.charAt(i);
        
        return 'a';
    }
}