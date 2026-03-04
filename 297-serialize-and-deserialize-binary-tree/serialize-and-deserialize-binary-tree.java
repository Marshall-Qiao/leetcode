/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (current == null) {
                sb.append("null,");
                continue;
            }
            sb.append(current.val + ",");
            q.add(current.left);
            q.add(current.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;
        String[] array = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 1;

        while (!q.isEmpty() && index < array.length) {
            TreeNode curr = q.poll();
            // left
            if (!array[index].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(array[index]));
                q.add(curr.left);
            }
            index++;
            // right
            if (index < array.length && !array[index].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(array[index]));
                q.add(curr.right);
            }
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));