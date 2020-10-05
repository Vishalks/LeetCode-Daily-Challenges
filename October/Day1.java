//SC: O(1)
//TC: O(1)
class RecentCounter {
    int[] time;
    
    public RecentCounter() {
        time = new int[3001];
    }
    
    public int ping(int t) {
        int res = 0;
        time[t % 3001] = t;
        for (int i = 0; i < 3001; i++) {
            if (time[i] != 0 && time[i] >= t - 3000) {
                res += 1;
            }
        }
        return res;
    }
}