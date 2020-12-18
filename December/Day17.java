//SC: O(n^2) since there can be unique n^2 combinations for a + b for first pair of nested loops
//TC: O(n^2)
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for(int a : A){
            for(int b : B){
                int s = a + b;
                map.put( s, map.getOrDefault(s, 0) + 1 );
            }
        }
        
        int result = 0;
        for(int c : C){
            for(int d : D){
                int s = -c-d;
                result += map.getOrDefault(s, 0);
            }
        }
        return result; 
    }
}