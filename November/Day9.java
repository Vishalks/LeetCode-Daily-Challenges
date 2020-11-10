//SC: O(n)
//TC: O(n)
class Solution {
    int result = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null)
            return 0;
        //helper(root);
        helper(root, root.val, root.val);
        return result;
    }
    
    public void helper(TreeNode node, int currMin, int currMax){
        if(node == null)
            return;
        
        //currentResult denotes the max absolute difference after considering the value of current node
        //update result after considering the current result obtained for the current node
        int currResult = Math.max(Math.abs(node.val - currMin), Math.abs(node.val - currMax));
        result = Math.max(result, currResult);
        
        //update currMin and currMax after considering the value of current node
        currMin = Math.min(currMin, node.val);
        currMax = Math.max(currMax, node.val);
        
        //call helper on left and right subtree
        helper(node.left, currMin, currMax);
        helper(node.right, currMin, currMax);
    }
    
    /*public List<Integer> helper(TreeNode root){
        //initialize the min and max vals as the val of root itself
        int minVal = root.val;
        int maxVal = root.val;
        
        if(root.left != null){
            //if root has left child, get the min and max values from the left subtree
            List<Integer> leftVals = helper(root.left);
            int leftMin = Math.min(leftVals.get(0), leftVals.get(1));
            int leftMax = Math.max(leftVals.get(0), leftVals.get(1));
            
            //calculate max difference from the left subtree and update result accordingly
            int maxLeftDiff = Math.max(Math.abs(root.val - leftMin), Math.abs(root.val - leftMax));
            result = Math.max(result, maxLeftDiff);
            
            //update the min and max vals initialized at the start after comparing with the min and max values from left subtree
            minVal = Math.min(minVal, leftMin);
            maxVal = Math.max(maxVal, leftMax);
        }
        
        //follow same logic for the right subtree
        if(root.right != null){
            List<Integer> rightVals = helper(root.right);
            int rightMin = Math.min(rightVals.get(0), rightVals.get(1));
            int rightMax = Math.max(rightVals.get(0), rightVals.get(1));
            
            int maxRightDiff = Math.max(Math.abs(root.val - rightMin), Math.abs(root.val - rightMax));
            result = Math.max(result, maxRightDiff);
            
            minVal = Math.min(minVal, rightMin);
            maxVal = Math.max(maxVal, rightMax);
        }
        //return min and max vals as a list
        return Arrays.asList(minVal, maxVal);
    }*/
}