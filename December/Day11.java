//SC: O(1)
//TC: O(n)
class Solution {
    
    //SC: O(1)
    //TC: O(n^2)
    /*public int removeDuplicates(int[] nums) {
        int n = nums.length, count = 0;
        if(n == 0)
            return 0;
        for(int i = 0; i < n-2; i++){
            //there are more than 2 numbers of same value
            if(nums[i] == nums[i+2]){
                int j = i+2;
                //traverse till there are duplicates and mark duplicates as minus infinity
                while(j < n && nums[j] == nums[i]){
                    count++;
                    nums[j] = Integer.MIN_VALUE;
                    j++;
                }
                i = j-1;//since j got increased during while loop and i will increase after this statement, set i = j-1 to not miss processing any element
            }
        }
        
        for(int i = 0; i < n; i++){
            //check if number was marked minus infinity in previous for loop
            if(nums[i] == Integer.MIN_VALUE){
                int j = i;
                //traverse while there are duplicates that are not needed as per requirement
                while(j < n-1 && nums[j] == Integer.MIN_VALUE)
                    j++;   
                nums[i] = nums[j];//update value at i(currently minus infinity) with valid value at j 
                nums[j] = Integer.MIN_VALUE;//mark nums[j] as infinity since it has been processed and put at proper place
            }
        }
        return n - count;//return count of numbers which are there in resulting array
    }*/
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n: nums){
            //if i < 2: to accomodate first 2 elements irrespective of if they are duplicates or not
            //if n > nums[i-2]: since array is sorted and there can be at max 2 same numbers in the array, any valid number will always be > nums[i-2] 
            if(i < 2 || n > nums[i-2]){
                nums[i] = n;
                i++;
            }
        }
        return i;
    }
}