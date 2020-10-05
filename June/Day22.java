//think about the number in 32 bits and just count how many 1s are there in each bit, and sum %= 3 will clear it once it reaches 3. After running for all the numbers for each bit, if we have a 1 in res, then that 1 belongs to the single number, we can simply move it back to its spot by doing res |= sum << i
//TC: O(32n) = O(n)
//SC: constant
//general solution for any times of occurrence. Say all the numbers have 5 times, just do sum %= 5
class Solution {
   public int singleNumber(int[] nums) {
    int res = 0;
    for(int i = 0; i < 32; i++){
        int sum = 0;
        for(int n: nums)
            if((n >> i & 1) == 1)
                sum++;
        sum %= 3;
        res |= sum<<i;
    }
    return res;
}
}