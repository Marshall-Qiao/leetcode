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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null) return null;

        ListNode tail = new ListNode();
        tail.next = head;
        // remove mid one
        ListNode fast = tail.next.next;
        ListNode slow = tail;

        while (fast != null) {
            if (fast.next == null || fast.next.next == null) {
                slow = slow.next;
                break;
            } 
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return tail.next;
    }
}