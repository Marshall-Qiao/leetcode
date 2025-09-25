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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode tail = new ListNode();
        tail.next = head;
        reverseMid(tail,left,right);
        return tail.next;
    }
    public void reverseMid(ListNode head, int left, int right) {
        for(int i = 1;i<left;i++) head = head.next;
        ListNode start = head.next;
        ListNode tail = new ListNode();
        while(left <= right){
            left++;
            ListNode temp = start.next;
            start.next = tail.next;
            tail.next = start;
            start = temp;
        }

        head.next.next = start;
        head.next = tail.next;
    }
}