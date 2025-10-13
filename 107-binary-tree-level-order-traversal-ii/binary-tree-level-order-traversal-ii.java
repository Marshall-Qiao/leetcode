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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        addDFSList(root, null, 0 ,res);
        Collections.reverse(res);
        return res;
    }

    public void addDFSList(TreeNode left, TreeNode right, int level, List<List<Integer>> res) {
        if (left == null && right == null) return;
        List<Integer> list = res.size() - 1 < level ? new ArrayList<>() : res.get(level);
        if (left != null) list.add(left.val);
        if (right != null) list.add(right.val);
        if (res.size() - 1 < level) {
            res.add(list);
        } else {
            res.set(level, list);
        }
        if (left != null) addDFSList(left.left, left.right, level + 1 ,res);
        if (right != null) addDFSList(right.left, right.right, level + 1 ,res);
    }

}