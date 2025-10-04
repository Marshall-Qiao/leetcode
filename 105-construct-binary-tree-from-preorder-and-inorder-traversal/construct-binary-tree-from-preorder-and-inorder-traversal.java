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
    private int preIndex = 0; // 全局指针

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) valToIndex.put(inorder[i],i);
        return build(preorder, 0, preorder.length - 1, valToIndex);
    }

    public TreeNode build(int[] preorder, int start, int end, Map<Integer, Integer> valToIndex) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        int inOrderIndex = valToIndex.get(preorder[preIndex]);
        preIndex++;
        
        root.left = build(preorder, start, inOrderIndex - 1, valToIndex);
        root.right = build(preorder, inOrderIndex + 1, end, valToIndex);
        return root;
    }
}