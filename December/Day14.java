//SC: O(N), where NN is the length of the string s. This space will be used to store the recursion stack.//TC: O(N*2^N) - there could be 2^N possible substrings in the worst case. For each substring, it takes O(N) time to generate substring and determine if it a palindrome or not. This gives time complexity as O(N*2^N)

//refer https://leetcode.com/problems/palindrome-partitioning/solution/
//Refer ecxample for string 'aaa'
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        dfs(0, result, s, new ArrayList());
        return result;
    }
    
    public void dfs(int start, List<List<String>> result, String s, List<String> currentList){
        //Backtrack if start index is greater than or equal to the string length and add the currentList to the result.
        if(start >= s.length()){
            result.add(new ArrayList(currentList));
            return;
        }
        
        //Iteratively generate all possible substrings beginning at start index. The end index increments from start till the end of the string
        for(int end = start; end < s.length(); end++){
            if(isPalindrome(s, start, end)){//For each of the substring generated, check if it is a palindrome
                
                //If the substring is a palindrome, the substring is a potential candidate. Add substring to the currentList and perform a depth-first search on the remaining substring. If current substring ends at index end, end+1 becomes the start index for the next recursive call
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, result, s, currentList);
                currentList.remove(currentList.size() - 1);//remove last string from current list for new combinations
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}