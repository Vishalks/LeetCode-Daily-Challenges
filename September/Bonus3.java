class Solution {
    public List<List<String>> wordSquares(String[] words) {
        Map<String, Set<String>> prefix = new HashMap<>();
        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                String str = word.substring(0, i);
                prefix.putIfAbsent(str, new HashSet<>());
                prefix.get(str).add(word);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        List<String> candidate = null;
        for (String word : words) {
            candidate = new ArrayList<>();
            candidate.add(word);
            dfs(candidate, 1, words[0].length(), prefix, res);
        }
        return res;
    }
    
    private void dfs(List<String> candidate, int pos, int len,
                     Map<String, Set<String>> prefix, List<List<String>> res) {
        if (pos == len) {
            res.add(new ArrayList<>(candidate));
            return;
        }
        // Get the next prefix;
        StringBuilder sb = new StringBuilder();
        for (String cand : candidate) {
            sb.append(cand.charAt(pos));
        }
        if (!prefix.containsKey(sb.toString())) {
            return;
        }

        for (String next : prefix.get(sb.toString())) {
            candidate.add(next);
            dfs(candidate, pos + 1, len, prefix, res);
            candidate.remove(candidate.size() - 1);
        }
    }
}