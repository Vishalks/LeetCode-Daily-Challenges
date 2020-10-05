//SC: O(1)
//TC: O(n)
class Solution {
    public int[] sortArrayByParity(int[] A){
     int index = 0,val;
     for(int i = 0; i < A.length; i++){
        if((A[i] % 2) == 0)//if even, swap values at index and i
        {
             val = A[index];
             A[index] = A[i];
             A[i] = val;
             index++;
        }
      }
      return A;
    }
}