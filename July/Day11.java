//TC: O(n*pow(2.n))
//SC: O(n*pow(2.n))
//While iterating through all numbers, for each new number, we can either pick it or not pick it
//1. if pick, just add current number to every existing subset.
//2. if not pick, just leave all existing subsets as they are.
//We just combine both into our result.
//For example, {1,2} intially we have an empty set as result [ [ ] ]
//Considering 1, if not use it, still [ ], if use 1, add it to [ ], so we have [1] now
//Combine them, now we have [ [ ], [1] ] as all possible subset

//Next considering 2, if not use it, we still have [ [ ], [1] ], if use 2, just add 2 to each previous subset, we have [2], [1,2]
//Combine them, now we have [ [ ], [1], [2], [1,2] ]
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        result.add(new ArrayList());//empty list to start with
        
        for(int i: nums){//for every number
            int size = result.size();//get number of subsets
            for(int j = 0; j < size; j++){//for each of the subset
                List<Integer> newSubset = new ArrayList<>(result.get(j));//we clone the subset
                newSubset.add(i);//add number to the cloned subset to form a new subset
                result.add(newSubset);//add the new subset to result
            }
        }
        return result;
    }
}