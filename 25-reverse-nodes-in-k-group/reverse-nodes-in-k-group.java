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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;

        ListNode tail = head;
        for(int i = 0; i < k; i++){
            if(tail == null) return head;
            tail = tail.next;
        }

        ListNode reveseNode = reverse(head,tail);
        head.next = reverseKGroup(tail,k);
        return reveseNode;
    }

    public ListNode reverse(ListNode start, ListNode end) {
            ListNode pre = null;
            while(start != end){
                ListNode next = start.next;
                start.next = pre;
                pre = start;
                start = next;
            }
            return pre;
    }
}