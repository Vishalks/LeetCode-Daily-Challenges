class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Double> dist = new HashMap<>();
        Map<String, String> root = new HashMap<>();
        int eqLen = equations.size();
        int queryLen = queries.size();
        double[] result = new double[queryLen];
        
        for(int i = 0; i < eqLen; i++){
            String num = equations.get(i).get(0);
            String den = equations.get(i).get(1);
            String r1 = find(dist, root, num);
            String r2 = find(dist, root, den);
            root.put(r1, r2);
            dist.put(r1, (double) values[i] * dist.get(den) / dist.get(num));
        }
        
        for(int i = 0; i < queryLen; i++){
            String num = queries.get(i).get(0);
            String den = queries.get(i).get(1);
            if(!root.containsKey(num) || !root.containsKey(den)){
                result[i] = -1;
                continue;
            }
            
            String r1 = find(dist, root, num);
            String r2 = find(dist, root, den);
            if(!r1.equals(r2)){
                result[i] = -1;
                continue;
            }
            
            result[i] = (double) dist.get(num) / dist.get(den); 
        }
        
        return result;
    }
    
    public String find(Map<String, Double> dist, Map<String, String> root, String s){
        if(!root.containsKey(s)){
            root.put(s, s);
            dist.put(s, 1.0);
            return s;
        }
        if(root.get(s).equals(s))
            return s;
        String lastP = root.get(s);
        String p = find(dist, root, lastP);
        root.put(s, p);
        dist.put(s, dist.get(s) * dist.get(lastP));
        return p;
    }
}