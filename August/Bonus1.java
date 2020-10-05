//TC: O(h) where h is height tree
//SC: O(h) for recursion stacks
public class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root.val == target)//if root.val = target, we found the closest value
            return root.val;
        
        TreeNode kid = null;
        if(root.val > target)
            kid = root.left;
        else
            kid = root.right;
        if (kid == null)//current root is the leaf so return root.val
            return root.val;
        
        int closestVal = closestValue(kid, target);//get second closest value to target other than root
        
        //return the closest value to target among the root and kid
        if (Math.abs(root.val - target) < Math.abs(closestVal - target))
            return root.val;
        else
            return closestVal;
    }
}