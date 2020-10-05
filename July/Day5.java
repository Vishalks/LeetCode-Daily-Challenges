class Solution {
    //TC: O(n)
    //SC: O(n)
    /*public int hammingDistance(int x, int y) {
        if(x == y)
            return 0;
        
        int xor = x^y;
        String xorStr = intToBinStr(xor);
        int result = 0;
        
        for(char ch: xorStr.toCharArray()){
            if(ch == '1')
                result++;
        }
        return result;
    }
    
    public String intToBinStr(int xor){
        StringBuilder str = new StringBuilder();
        while(xor > 0){
            str.append((char)('0' + (xor % 2)));
            xor /= 2;
        }
        return str.toString();
    }*/
    
    //TC: O(n)
    //SC: O(1)
    public int hammingDistance(int x, int y) {
        int count = 0;
        
        if(x == y) {
            return count;
        }
        
        while(x != 0 && y !=0) {
            int xbit = (1 & x);
            int ybit = (1 & y); 
            if(xbit != ybit) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;       
        }
        
        //if one of the number finishes before the other
        while(x != 0) {
            int xbit = (1 & x);
            if(xbit != 0) {
                count++;
            }
             x = x >> 1;
        }
        
         while(y != 0) {
            int ybit = (1 & y);
            if(ybit != 0) {
                count++;
            }
             y = y >> 1;
        } 
        
        return count;  
    }
}