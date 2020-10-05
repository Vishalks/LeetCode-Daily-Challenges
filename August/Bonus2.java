class Solution {
   public int[] findPermutation(String s) {
      int n = s.length();
      int[] res = new int[n + 1];
      for(int i = 0; i < res.length; i++) res[i] = i + 1;
      char[] sc = s.toCharArray();
      for(int i = 0; i < n; i++){
        if(sc[i] == 'D'){
          int start = i;
          while(i < n && sc[i] == 'D') i++;
          reverse(res, start, i);
        }
      }
      return res;
    }
    
    void reverse(int[] res, int start, int end){
      while(start < end){
        int temp = res[start];
        res[start]  = res[end];
        res[end] = temp;
        start++;
        end--;
      }    
    }
}