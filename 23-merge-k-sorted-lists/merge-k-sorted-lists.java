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
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> q = new PriorityQueue<>((a, b)-> a.val - b.val);
            for (ListNode node : lists) {
                if(node != null) q.add(node);
            }
            ListNode dummy = new ListNode();
            ListNode temp = dummy;
            while (!q.isEmpty()) {
                ListNode curr = q.poll();
                temp.next = curr;
                temp = temp.next;
                
                if(curr.next != null) q.add(curr.next);
            }
            return dummy.next;

        }
//     public ListNode mergeKLists(ListNode[] lists) {
//       if (lists == null || lists.length == 0) return null;
//       List<ListNode> newList = Arrays.stream(lists).toList();
//       while (newList.size() > 1) {
//          List<ListNode> tempList = new ArrayList<>();
//          for (int i = 0; i < newList.size(); i = i + 2) {
//             ListNode node1 = newList.get(i);
//             ListNode node2 = (i + 1) < newList.size() ? newList.get(i + 1) : null;
//             tempList.add(mergeTwoList(node1, node2));
//          }
//          newList = tempList;
//       }
//       return newList.get(0);
//     }
   
//    public ListNode mergeTwoList(ListNode node1, ListNode node2) {
//        ListNode tail = new ListNode();
//        ListNode temp = tail;
//        while (node1 != null && node2 != null) {
//            if (node1.val > node2.val) {
//                 temp.next = node2;
//                 node2 = node2.next;
//            } else {
//                 temp.next = node1;
//                 node1 = node1.next;
//            }
//            temp = temp.next;
//        }
//        temp.next = node1 == null ? node2 : node1;
//        return tail.next;
//     }

}