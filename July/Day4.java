//TC: O(1)
//SC: O(1)
class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[1690];
        nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int num;
        
        for(int i = 1; i < n; i++){
            num = Math.min(Math.min(nums[i2]*2, nums[i3]*3), nums[i5]*5);
            nums[i] = num;
            
            if(num == 2*nums[i2])
                i2++;
            if(num == 3*nums[i3])
                i3++;
            if(num == 5*nums[i5])
                i5++;
        }
        return nums[n-1];
    }
}