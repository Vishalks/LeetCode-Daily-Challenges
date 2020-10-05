//TC: O(N^target) where N is a length of candidates array
//SC: O(target) since recursion can go target layers deep
class Solution {
    List<List<Integer>> result = new ArrayList();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(new ArrayList(), candidates, target, 0, 0);
        return result;
    }
    
    public void backtrack(List<Integer> combination, int[] candidates, int target, int sum, int start){
        if(target == sum){//we have got the combination that sums to n, so add this combination to result and return
            result.add(new ArrayList<>(combination));
            return;
        }
        
        if(sum > target)//we have exceeded the target so return
            return;
        
        //try getting the combination for each number from start to end of candidate array
        for(int i = start; i < candidates.length; i++){
            combination.add(candidates[i]);
            backtrack(combination, candidates, target, sum + candidates[i], i);//since duplicate numbers are allowed in a combination, we call backtrack again with same start i but update sum by adding number at index start in candidates to sum
            combination.remove(combination.size() - 1);//remove last number from combination to explore other combinations
        }
    }
}