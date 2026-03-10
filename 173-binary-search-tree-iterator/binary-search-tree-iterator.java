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
class BSTIterator {
    LinkedList<Integer> treeList;

    public BSTIterator(TreeNode root) {
        treeList = new LinkedList<>();
        getBSTList(root, treeList);
    }
    public void getBSTList(TreeNode node, List<Integer> list) {
        if (node == null) return;
        getBSTList(node.left, list);
        list.add(node.val);
        getBSTList(node.right, list);
    }
    
    public int next() {
        if (treeList.size() == 0) return -1;
        int val = treeList.get(0);
        treeList.remove(0);
        return val;
    }
    
    public boolean hasNext() {
        return treeList.size() != 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */