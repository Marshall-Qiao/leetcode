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
    int countSum = 0;
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new LinkedList<>();
        helper(root, targetSum, list);
        return countSum;
    }

    public void helper(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        // todo check if hit 
        sumTargetList(targetSum,list);
        helper(root.left, targetSum, list);
        helper(root.right, targetSum, list);
        list.removeLast();
    }

    public void sumTargetList(int targetSum, List<Integer> list) {
        long sum = (long) targetSum;
        long count = 0;
        for (int i = list.size() - 1; i >= 0 ; i--) {
            count += list.get(i);
            if (count == sum) countSum++;
        }
    }

    // public int pathSum(TreeNode root, int targetSum) {
    //    List<Integer> list = new LinkedList<Integer>();
    //    return getPath(root,targetSum,list);
    // }
    // public int getPath(TreeNode root,int targetSum, List<Integer> before){
    //     if(root == null) return 0;
    //     int res = 0;
    //     before.add(root.val);

    //     long sum = 0;
    //     for(int i = before.size()-1; i>= 0; i--){
    //         sum += before.get(i);
    //         if(sum == targetSum) res++;
    //     }

    //     res += getPath(root.left,targetSum,before);
    //     if(root.left != null ) before.removeLast();
    //     res += getPath(root.right,targetSum,before);
    //     if(root.right != null ) before.removeLast();

    //     return res;
    // }

    // public void newKeyHandle(Map<Integer,Integer> map,Integer key,boolean add){
    //         Integer value= map.get(key);
    //         if(value == null) value = 0;
    //         if(add){
    //             value++;
    //         } else{
    //             value--;
    //         }
    //         map.put(key,value);
    // }
}