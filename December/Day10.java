//SC: O(1)
//TC: O(n)
class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n <= 2)
            return false;
        int i = 0;
        
        //get the index of peak in the mountain
        while(i < n - 2){
            if(arr[i] >= arr[i+1])
                break;
            i++;
        }
        
        //if the very first element is the peak, array is not a mountain
        if(i == 0)
            return false;
        
        //check if all values to right of peak make a valley
        while(i < n - 1){
            if(arr[i] <= arr[i+1])
                return false;
            i++;
        }
        return true;
    }
}