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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key > root.val){
            root.right = deleteNode(root.right,key);
        }else if(key < root.val){
            root.left = deleteNode(root.left,key);
        }else{
            if(root.left == null && root.right == null) return null;
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            
            TreeNode leftMax = findLeftMax(root.left);
            root.val = leftMax.val;
            root.left = deleteNode(root.left,leftMax.val);
        }
        return root;
    }

    public TreeNode findLeftMax(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
}