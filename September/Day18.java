//TC: O(n)
//SC: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;//set buyPrice to be largest. This would help us in minimizing buy price when we iterate over input and thus maximize profit
        for(int p: prices){
            buyPrice = Math.min(p, buyPrice);//get min of current buy price and input price p. we always want to buy at least price
            maxProfit = Math.max(maxProfit, p - buyPrice);//get max of current maxProfit and profit obtained after selling at current input price p
        }
        return maxProfit;
    }
}