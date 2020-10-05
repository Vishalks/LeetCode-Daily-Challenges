//TC: O(n) due to  inorder on both trees
//SC: O(n)
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> listTobeMerged = new LinkedList<>();
        LinkedList<Integer> mergedList = new LinkedList<>();

        inorder(root1, listTobeMerged);
        merge(root2, mergedList, listTobeMerged);

        mergedList.addAll(listTobeMerged);
        return mergedList;
    }

    // add all node values from tree 1 in inorder fashion in list to be merged
    private void inorder(TreeNode node, LinkedList<Integer> listTobeMerged) {
        if (node == null) return;

        inorder(node.left, listTobeMerged);
        listTobeMerged.add(node.val);
        inorder(node.right, listTobeMerged);
    }

    // merge nodes from tree 2 (in inorder fashion) and list to be merged into merged list 
    private void merge(TreeNode root, LinkedList<Integer> mergedList, LinkedList<Integer> listTobeMerged) {
        if (root == null)
            return;

        merge(root.left, mergedList, listTobeMerged);

        // this maintains the ascending order of nodes in final merged list
        while (!listTobeMerged.isEmpty() && listTobeMerged.peek() < root.val) {
            mergedList.add(listTobeMerged.poll());
        }

        mergedList.add(root.val);
        merge(root.right, mergedList, listTobeMerged);
    }
}