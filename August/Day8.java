class Solution {
    int count = 0, sum;
    HashMap<Integer, Integer> map = new HashMap();
    
    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        helper(root, 0);
        return this.count;
    }
    
    public void helper(TreeNode root, int prev_sum) {
        if(root == null) return;
        
        int curr_sum = prev_sum + root.val;
        
        // If the path from the root yields the targets
        if(curr_sum == sum) count++;
        
        // If the path from the root, minus root to any prev node, yields the targets
        count += map.getOrDefault(curr_sum - sum, 0);
        
        // Put curr_sum (from root to current node) to map
        map.put(curr_sum, map.getOrDefault(curr_sum, 0) + 1);
        
        // Recurse with left and right subtree
        helper(root.left, curr_sum);
        helper(root.right, curr_sum);
        
        // Remove the curr_sum from map since we are done with this subtree
        map.put(curr_sum, map.get(curr_sum) - 1);
    }
}