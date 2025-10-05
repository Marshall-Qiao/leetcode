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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode build(int[] preorder, int preL, int preR, int[] postorder, int posL, int posR) {
        if (posL > posR) return null;
        if (preL == preR) return new TreeNode(postorder[posR]);
        TreeNode root = new TreeNode(postorder[posR]);
        int nextIndex = getNextIndex(preorder[preL+1], postorder, posL, posR);
        int lcount = nextIndex - posL + 1;
        root.left = build(preorder, preL+1, preL + lcount, postorder, posL, posL + lcount - 1);
        root.right = build(preorder, preL + lcount + 1, preR, postorder, posL + lcount, posR - 1);
        return root;
    }

    public int getNextIndex(int value, int[] postorder, int posL, int posR){
        for (int i = posL; i < posR; i++){
            if (postorder[i] == value) return i;
        }
        return posR;
    }
}