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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode tail = new ListNode(0,head);
        Map<Long,ListNode> map = new HashMap<Long,ListNode>();
        ListNode temp = head;
        long sum = 0;
        while(temp != null){
            sum += (long)temp.val;
            map.put(sum,temp);
            temp = temp.next;
        }

        temp = tail;
        sum = 0;
        while(temp != null){
            sum += (long)temp.val;
            if(map.get(sum) != null){
                ListNode last = map.get(sum);
                temp.next = last.next;
            }
            temp = temp.next;
        }
        return tail.next;
    }
}