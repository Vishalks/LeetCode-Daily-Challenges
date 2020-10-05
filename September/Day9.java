//SC: O(n)
//TC: O(n)
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int l1 = v1.length;
        int l2 = v2.length;
        int i = 0, j = 0;
        
        while(i < l1 && j < l2){
            int val1 = Integer.valueOf(v1[i]);
            int val2 = Integer.valueOf(v2[j]);
            if(val1 < val2)
                return -1;
            else if(val1 > val2)
                return 1;
            else{
                i++;
                j++;
            }
        }
        
        //for cases like 1 and 1.0
        if(i == l1 && j != l2){
            while(j != l2){
                if(Integer.valueOf(v2[j]) != 0)
                    return -1;
                j++;
            }
        }
        //for cases like 1.0 and 1
        if(i != l1 && j == l2){
             while(i != l1){
                if(Integer.valueOf(v1[i]) != 0)
                    return 1;
                 i++;
            }
        }
        return 0;
    }
}