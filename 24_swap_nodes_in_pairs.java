/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode p0 = null;
        ListNode p1 = head;
        if (p1 == null) {
          return head;
        }
        ListNode p2 = p1.next;
        if (p2 == null) {
          return head;
        }
        head = p2;
        while (p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1.next = temp;
            if (p0 != null) {
                p0.next = p2;
            }
            p0 = p1;
            if (temp == null) {
                return head;
            }
            p1 = temp;
            p2 = temp.next;
        }
        return head;
    }
}
