//SC: O(1)
//TC: O(nlogm) where n is total number of elements in input, m is max number in the array
class Solution {
    public int smallestDivisor(int[] A, int threshold) {
        int left = 1, right = Integer.MIN_VALUE;
        //find max among the entire input
        for(int n: A)
            right = Math.max(right, n);
        
        //binary search
        while (left < right) {
            int mid = (left + right) / 2, sum = 0;
            
            //calculate sum after dividing each element in the array with mid, take floor when not completely divisible
            for (int i : A)
                sum += (i + mid - 1) / mid;
            
            //adjusting left and right boundary of search depending on sum
            if (sum > threshold)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}