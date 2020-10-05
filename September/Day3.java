//SC: O(1)
//TC: O(n) in case when all characters in string are same
class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
    	for(int i = len / 2 ; i >= 1 ; i--) {
    		if(len % i == 0) {//i is the length of original string
    			int m = len / i;//number of possible occurences of original substring
    			String subS = str.substring(0,i);
    			int j;
    			for(j = 1; j < m; j++) {//run a loop to check if every substring of length i after the original substring ends equals the original substring
    				if(!subS.equals(str.substring(j*i, i + j*i)))
                        break;
    			}
    			if(j == m)//this means we traversed entire string and found that string can be built by appending the substring many times
    			    return true;
    		}
    	}
    	return false;
    }
}