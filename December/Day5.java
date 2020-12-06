//TC: O(n)
//SC: O(1)
class Solution {
   public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        int count = 0;
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 1)//since i is not empty, move i by 2 since there can't be 2 adjacent flowers
                i += 2;
            else if ((i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
                count++;//flower can be planted at i so increase counter
                if (count == n)//all flowers planted
                    return true;
                i += 2;//since we planted flower at i, move i by 2 since there can't be 2 adjacent flowers
            }
            else 
                i++;//for condition like 0 i 1 OR 1 i 0
        }
        return false;
    }
}