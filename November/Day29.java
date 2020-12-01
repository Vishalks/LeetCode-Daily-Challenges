//SC: O(n)
//TC: O(n)
class Solution {
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length || arr[start] == arr.length)//when start is invalid or arr[start] is already visited
            return false;
        if(arr[start] == 0)//can reach
            return true;
        int x = arr[start];//get original value at arr[start]
        arr[start] = arr.length;//mark as visited since valid input won't have value = length of array at any index
        return canReach(arr, start + x) || canReach(arr, start - x);//try if we can reach to 0 valued index from either start +- x index
    }
}