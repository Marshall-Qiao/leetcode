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
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int resLevel = 1, currLevel = 1;
        int maxCount = Integer.MIN_VALUE;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (list.size() != 0) {
            List<TreeNode> currList = new ArrayList<>();
            int currCount = 0;
            for (int i = 0; i < list.size(); i++) {
                currCount += list.get(i).val;
                if (list.get(i).left != null) currList.add(list.get(i).left);
                if (list.get(i).right != null) currList.add(list.get(i).right);
            }
            if (currCount > maxCount) {
                maxCount = currCount;
                resLevel = currLevel;
            }
            currLevel++;
            list = currList;
        }
        return resLevel;
    }
}