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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
         
        ListNode evenNode = new ListNode();
        ListNode temp = evenNode;
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            ListNode nowEven = tail.next;
            tail.next =  nowEven.next;
            if (nowEven.next != null) tail = nowEven.next;

            nowEven.next = null;
            temp.next = nowEven;
            temp = nowEven;
        }
        tail.next = evenNode.next;
        return head;
    }
}