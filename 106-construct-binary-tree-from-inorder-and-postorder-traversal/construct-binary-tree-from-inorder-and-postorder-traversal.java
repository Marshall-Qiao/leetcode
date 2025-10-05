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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    public TreeNode build(int[] inorder,int il, int ir, int[] postorder, int pl, int pr) {
        if (il > ir || pl > pr) return null;
        TreeNode root = new TreeNode(postorder[pr]);
        int nowInd = getIndexFromInorder(inorder,il,ir,postorder[pr]);
        int lcount = nowInd - il;
        root.left = build(inorder, il, nowInd - 1, postorder, pl, pl + lcount - 1);
        root.right = build(inorder, nowInd + 1, ir, postorder, pl + lcount, pr - 1);
        return root;
    }

     public int getIndexFromInorder(int[] inorder,int il, int ir, int value) {
        for (int i = il; i <= ir; i++){
            if (inorder[i] == value) {
                return i;
            }
        } 
        return inorder.length;
    }

}