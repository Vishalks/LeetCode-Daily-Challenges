//SC: O(1)
//TC: O(1)
class Solution {
    public int bitwiseComplement(int num) {
        if(num == 0)
            return 1;
        
        int todo = num, bit = 1;
        while (todo != 0) {
          // flip current bit
          num = num ^ bit;
          // prepare for the next run
          bit = bit << 1;
          todo = todo >> 1;
        }
        return num;
    }
}