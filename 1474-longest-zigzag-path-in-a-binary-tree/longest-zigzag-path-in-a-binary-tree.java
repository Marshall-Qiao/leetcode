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
    int res = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        helper(root.left, 1, true);
        helper(root.right, 1, false);
        return res;
    }
    public void helper(TreeNode root, int max, boolean beforeLeft) {
        if (root == null) {
            res = Math.max(res, max - 1);
            return;
        }
        if (beforeLeft) {
            helper(root.left, 1, true);
            helper(root.right, max + 1, false);
        } else {
            helper(root.left, max + 1, true);
            helper(root.right, 1, false);
        }
    }
}