class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
       int graph[][] = new int[n][n];
        
        for(int f[] : flights) {
            graph[f[0]][f[1]] = f[2];//create matrix of src, dest and price
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[]{src, 0, K});//src, price, stops. queue stores least price first
        
        while(!pq.isEmpty()) {
            int head[] = pq.poll();
            int airport = head[0], price = head[1], stops = head[2];
            if(airport == dst) return price;
            if(stops >= 0) {
                for(int i = 0; i < n; i++) {//for each city that has connecting flights from airport
                    if(graph[airport][i] > 0) {
                        pq.offer(new int[]{i, price + graph[airport][i], stops - 1});
                    }
                }
            }
        }
        
        return -1;
    }
}