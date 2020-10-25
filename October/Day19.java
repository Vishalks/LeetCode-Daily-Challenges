//SC: O(1)
//TC: O(1)
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        if(n == 0)
            return -1;
        int rotations = check(A[0], A, B, n);
        if(rotations != -1)
            return rotations;
        else
            return check(B[0], A, B, n);
    }
    
    public int check(int x, int[] A, int[] B, int n){
        int rotationsA = 0, rotationsB = 0;
        for(int i = 0; i < n; i++){
            if(x != A[i] && x != B[i])
                return -1;
            else if(x != A[i])
                rotationsA++;            
            else if(x != B[i])
                rotationsB++;
        }
        
        return Math.min(rotationsA, rotationsB);
    }
}