//SC: O(n) for both due to recursion stack
//TC: O(n) for both
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serial(new StringBuilder(), root).toString();
    }
    
    private StringBuilder serial(StringBuilder sb, TreeNode root){
        if(root == null){
            sb.append("#");
            return sb;
        }
        sb.append(root.val).append(",");
        serial(sb, root.left).append(",");
        serial(sb, root.right);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
    }
    
    private TreeNode deserial(Queue<String> q){
        String s = q.poll();
        if(s.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = deserial(q);
        root.right = deserial(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;