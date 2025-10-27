/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        int size = 0;
        ListNode tail = head;
        Map<Integer,Integer> map = new HashMap<>(); 
        while (tail != null) {
            size++;
            map.put(size,tail.val);
            tail = tail.next;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= size / 2; i++){
            int first = i, last = size - i + 1;
            res = Math.max(res,map.get(first) + map.get(last));
        }
        return res;
    }
}