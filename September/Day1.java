//SC: O(1)
//TC: O(1)
class Solution {
    
    private boolean rearrange(int maxValue,int index,int[] a){
        int max = -1;
		
		// find the maximum number for the given index which should be less than equal to maxValue
        for(int i = index; i < a.length; i++)
            if(a[i] <= maxValue && (max == -1 || a[max] < a[i]))
                max = i;
		// number not found
        if(max == -1)
            return false;
    
	// put the number to its correct index. swap it put at correct position
        int temp = a[max];
        a[max] = a[index];
        a[index] = temp;
        return true;
    }
    
    public String largestTimeFromDigits(int[] a) {
        /*Case 1: if 1st digit is 2 then 2nd digit value can  be 0<=value<=3
else if 1st digit is less than 2 then 2nd digit value can be 0<=value<=9. for 3rd digit 0<=value<=5 and for 4th digit 0<=value<=9*/
        boolean res = (rearrange(2, 0, a) && (a[0] == 2 ? rearrange(3, 1, a) : rearrange(9, 1, a)) && rearrange(5, 2, a) && rearrange(9, 3, a))
            
        /*When case 1 fails for string like 16:26
        1st digit  :  0<=value<=1
        2nd digit  : 0<=value<=9
        3rd digit  : 0<=value<=5
        4rth digit  : 0<=value<=9
        */
            || (rearrange(1, 0, a) && rearrange(9, 1, a) && rearrange(5, 2, a) && rearrange(9, 3, a));
        
        
        StringBuilder sb = new StringBuilder();
        
        if(!res)
            return sb.toString();
        
        return sb.append(String.valueOf(a[0])).append(String.valueOf(a[1])).append(':').append(String.valueOf(a[2])).append(String.valueOf(a[3])).toString();
    }
}