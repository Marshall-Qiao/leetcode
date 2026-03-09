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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeByIndex(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }
    public TreeNode buildTreeByIndex(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> inorderMap) {
        if (preLeft > preRight) return null;
        if (preLeft == preRight) return new TreeNode(preorder[preLeft]);

        TreeNode newTemp = new TreeNode(preorder[preLeft]);
        int tempIndex = inorderMap.get(preorder[preLeft]);
        int leftCount = tempIndex - inLeft;
        int rightCount = inRight - tempIndex;
        if (leftCount >= 1) {
            newTemp.left = buildTreeByIndex(preorder, preLeft + 1, preLeft + leftCount, inorder, inLeft, tempIndex - 1, inorderMap);
        }

        if (rightCount >= 1) {
            newTemp.right = buildTreeByIndex(preorder, preRight - rightCount + 1, preRight, inorder, tempIndex + 1, inRight, inorderMap);
        }
        return newTemp;
    }

}