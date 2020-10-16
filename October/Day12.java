//SC: O(1)
//TC: O(n)
class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length())
            return false;
        
        int a = -1, b = -1, diff = 0;
        int[] count = new int[26];
        boolean canSwitch = false;
        
        for(int i = 0; i < A.length(); i++){
            count[A.charAt(i) - 'a']++;
            //this means there are duplicate chars in A and they can be switched with each other
            if(count[A.charAt(i) - 'a'] >= 2)
                canSwitch = true;
            // in case char at A and B are not same, increment diff and store the index where they differ
            if(A.charAt(i) != B.charAt(i)){
                diff++;
                if(a == -1)
                    a = i;
                else if(b == -1)
                    b = i;
            }
        }
        //if there is no difference in both strings and both of them contain duplicates, we can swap duplicates in A to get B
        //Or if 2 chars differ in between A and B and both can be swapped to get B
        return (diff == 0 && canSwitch) || (diff == 2 && A.charAt(a) == B.charAt(b) && A.charAt(b) == B.charAt(a));
    }
}