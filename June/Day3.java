class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Comparator<int[]> c = (a, b) -> ((a[0]-a[1]) - (b[0]-b[1]));
        Arrays.sort(costs, c);
        
        int n = costs.length;
        int result = 0;
        for(int i = 0; i < n/2; i++)
            result += costs[i][0] + costs[i+n/2][1];
        
        return result;
    }
}