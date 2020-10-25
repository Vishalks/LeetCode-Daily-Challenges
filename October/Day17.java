//SC: O(n)
//TC: O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.isEmpty())
            return new ArrayList<>();
        
        Set<String> seqList = new HashSet();
        Set<String> list = new HashSet();
        
        for(int i = 0; i < s.length() - 9; i++) {
            String seq = s.substring(i, i + 10);
            if(seqList.contains(seq)) 
                list.add(seq);
            else
                seqList.add(seq);
        }
        return new ArrayList<>(list);
    }
}