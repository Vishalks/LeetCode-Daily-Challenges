//SC: O(1)
//TC: O(n)
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int word1Index = -1, word2Index = -1;
        int n = words.length;
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            if(words[i].equals(word1)){
                word1Index = i;
            }
            if(words[i].equals(word2)){
                word2Index = i;
            }
            //update result only when we have found both words atleast once
            if(word1Index != -1 && word2Index != -1){
                result = Math.min(result, Math.abs(word1Index - word2Index));
            }
        }
        return result;
    }
}