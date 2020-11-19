//SC: O(n)
//TC: O(n)
class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for(int[] interval : intervals){
            if(toBeRemoved[0] > interval[0] && toBeRemoved[0] < interval[1]){
                List<Integer> list = new ArrayList<>();
                list.add(interval[0]);
                list.add(toBeRemoved[0]);
                res.add(list);
            }

            if(toBeRemoved[1] < interval[1] && toBeRemoved[1] > interval[0]){
                List<Integer> list = new ArrayList<>();
                list.add(toBeRemoved[1]);
                list.add(interval[1]);
                res.add(list);
            }

            if(toBeRemoved[0] >= interval[1] || interval[0] >= toBeRemoved[1]){
                List<Integer> list = new ArrayList<>();
                list.add(interval[0]);
                list.add(interval[1]);
                res.add(list);
            }
        }
    return res;
    }
}