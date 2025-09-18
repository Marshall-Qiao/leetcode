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
    int maxVal = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root,0);
        return maxVal;
    }

    public int dfs(TreeNode root,int val) {
        if(root == null) return 0;
        int left = dfs(root.left,root.val);
        int right = dfs(root.right,root.val);
        maxVal = Math.max(maxVal,left + right);
        return root.val != val ? 0 : 1 + Math.max(left,right);
    }
    
}