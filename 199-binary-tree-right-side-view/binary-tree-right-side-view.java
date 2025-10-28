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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (list.size() != 0) {
            res.add(list.get(0).val);
            List<TreeNode> currList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                TreeNode curr = list.get(i);
                if (curr.right != null) currList.add(curr.right);
                if (curr.left != null) currList.add(curr.left);
            }
            list = currList;
        }
        return res;
    }
}