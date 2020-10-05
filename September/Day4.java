class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastSeen = new int[26];
        List<Integer> result = new ArrayList();
        char[] arr = S.toCharArray();
        for(int i = 0; i < arr.length; i++)
            lastSeen[arr[i] - 'a'] = i;
        
        int anchor = 0;
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            j = Math.max(j, lastSeen[arr[i] - 'a']);
            if(i == j){
                result.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return result;
    }
}