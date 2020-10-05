//TC: O(n)
//SC: O(n)
class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
       String[] split = s.split("\\s");
        if(split.length == 0)
            return 0;
        return split[split.length - 1].length();
    }
}