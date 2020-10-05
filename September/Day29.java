//SC: O(n)
//TC: O(n^2) since we run loops for i and j
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                //since dp[j] = false, no substring starting from current position of j till i-1 contains in the wordDict. So increase j
                if(!dp[j])
                    continue;
                //if dp[j] is true, we check if the substring is ni the wordDict. If yes, we mark dp[i] as true meaning a substring ending at i was there in wordDict
                if(wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}