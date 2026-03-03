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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isAddNext = false;
        ListNode head = new ListNode();
        ListNode temp = head;
        while (l1 != null || l2 != null || isAddNext) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + (isAddNext ? 1 : 0);
            isAddNext = sum >= 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return head.next;
    }


}