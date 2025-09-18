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


    int best = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // Math.max(max(left)+max(rihgt)+val)
        maxValue(root);
        return best;
    }
    public int maxValue(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(maxValue(root.left),0);
        int right = Math.max(maxValue(root.right),0);
        int maxNow = left+right + root.val;
        best = Math.max(best,maxNow);
        // return max gain include current node to parent
        return root.val + Math.max(left,right);
    } 
}