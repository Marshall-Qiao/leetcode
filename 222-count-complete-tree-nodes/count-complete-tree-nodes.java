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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left  == null && root.right  == null) return 1;
        TreeNode left = root;
        TreeNode right = root;
        int lh = 1, rh = 1;
        while(left.left != null){
           left = left.left; 
           lh++;
        }
         while(right.right != null){
           right = right.right; 
           rh++;
        }
        if(lh == rh){
            return (1<<lh)-1;
        }
        return 1 + countNodes(root.left)+ countNodes(root.right);
    }
}