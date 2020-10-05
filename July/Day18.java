class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap();
        
        for(int[] c: prerequisites){
            int src = c[0];
            int dest = c[1];
            if(!map.containsKey(dest)){
                map.put(dest, new ArrayList());
            }
            map.get(dest).add(src);
            inDegree[src]++;
        }
        
        Queue<Integer> q = new LinkedList();
        
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0)
                q.add(i);
        }
        
        int j = 0;
        
        while(!q.isEmpty()){
            int c = q.poll();
            result[j++] = c;
            
            if(map.containsKey(c)){
                List<Integer> courses = map.get(c);
                for(int src: courses){
                    inDegree[src]--;

                    if(inDegree[src] == 0)
                        q.add(src);
                }
            }
        }
        
        if(j == numCourses)
            return result;
        else
            return new int[0];
    }
}