//TC: O(n^2)
//SC: O(n)
//No of flips: 2*n
class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int n = A.length; n > 0; n--) {
            int maxIndex = find(A, n);//find index of max number in the array from index 0 to n
            flip(A, maxIndex);//flip array till maxIndex so as to put max number at start of the array
            flip(A, n-1);//again flip the entire array so the max number is now at the end after flip
            res.add(maxIndex+1);//add number of flips
            res.add(n);
        }
        return res;
    }
    
    public void flip(int[] A, int n){
        int start = 0;
        int end = n;
        while(start < end){
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }

    public int find(int[] A, int target){
        for(int i = 0; i < A.length; i++){
            if(A[i] == target)
                return i;
        }
        return -1;
    }
}