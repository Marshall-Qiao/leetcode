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
    int goodNode = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        goodNodeWithMaxVal(root, root.val);
        return goodNode;
    }
    public void goodNodeWithMaxVal(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) {
            goodNode++;
            max = root.val;
        }
        goodNodeWithMaxVal(root.left, max);
        goodNodeWithMaxVal(root.right, max);
    }
    
}