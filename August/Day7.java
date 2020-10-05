/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public class Node implements Comparable<Node>{
        public int val;
        public int y;
        
        public Node(int val, int y){
            this.val = val;
            this.y = y;
        }
        
        @Override
        public int compareTo(Node other){
            if(this.y == other.y)
                return this.val - other.val;
            return other.y - this.y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Map<Integer, List<Node>> map = new HashMap();
        dfs(root, map, 0, 0);
        
        int min = Integer.MAX_VALUE;
        for(int key: map.keySet())
            if(min > key)
                min = key;
        
        int index = min;
        while(map.get(index) != null){
            List<Node> list = map.get(index);
            Collections.sort(list);
            List<Integer> res = new ArrayList();
            for(Node node: list)
                res.add(node.val);
            result.add(res);
            index++;
        }
        
        return result;
        
    }
    
    public void dfs(TreeNode root, Map<Integer, List<Node>> map, int x, int y){
        if(root == null)
            return;
        if(!map.containsKey(x))
            map.put(x, new ArrayList());
        map.get(x).add(new Node(root.val, y));
        
        dfs(root.left, map, x-1, y-1);
        dfs(root.right, map, x+1, y-1);
    }
}