//SC: O(1)
//TC: O(1)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet();
        for(int i: days)
            set.add(i);
        
        int[] dp = new int[366];
        for(int i = 1; i < 366; i++){
            if(set.contains(i)){//for days in input array, minimum cost is a minimum of yesterday's cost plus single-day ticket, or cost for 8 days ago plus 7-day pass, or cost 31 days ago plus 30-day pass
                dp[i] = Math.min(dp[i-1] + costs[0], Math.min(dp[Math.max(0, i-7)] + costs[1], dp[Math.max(0, i-30)] + costs[2]));
            }
            else//for days not in input array, we travel free since we have buyed the pass for that day
                dp[i] = dp[i-1];
        }
        return dp[365];
    }
}