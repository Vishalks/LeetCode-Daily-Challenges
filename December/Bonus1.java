//SC: O(1) ignoring space for result
//TC: O(n)
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList();
        long start = lower;
        
        for(int n: nums){
            long end = n - 1;//set end as number-1. Now we have a range from start to end.
            addRange(start, end, result);//check if we can add range with this start and end
            start = n + 1;//reset start as number+1 for the next number in iteration
        }
        addRange(start, upper, result);//to handle case when last number is less than given upper limit
        return result;
    }
    
    public void addRange(long start, long end, List<String> result){
        if(start == end)
            result.add(String.valueOf(start));
        else if(start < end)
            result.add(String.valueOf(start) + "->" + String.valueOf(end));
    }
}