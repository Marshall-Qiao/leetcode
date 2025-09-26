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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode tail = new ListNode();
        tail.next = head;
        swapByNumber(tail);
        return tail.next;
    }
    public void swapByNumber(ListNode head) {
        if(head.next== null || head.next.next == null) return;
        ListNode node1 = head.next;
        ListNode node2 = head.next.next;
        ListNode node3 = head.next.next.next;
        head.next = node2;
        node2.next = node1;
        node1.next = node3;
        swapByNumber(node1);
    }

}