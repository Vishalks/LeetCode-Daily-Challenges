class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //sort the elements in descending order acc to their height.
        //if 2 elements have same height, sort in ascending order of their k-values
        Comparator<int[]> c = (a, b) -> (a[0] == b[0] ? (a[1] - b[1]): (b[0] - a[0]));
        Arrays.sort(people, c);
        List<int[]> result = new ArrayList();
        int n = people.length;
        
            //insert each element at the kth-value position in the list. If some element is already there, this element will be auto inserted before it and the earlier element will shift one place to right
        for(int i = 0 ; i < n; i++)
            result.add(people[i][1],people[i]);
        
        return result.toArray(new int[n][2]);
    }
}