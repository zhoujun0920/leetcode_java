/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode p1 = head;
        if (p1 == null) {
            return head;
        }
        while (p1.val == val) {
            p1 = p1.next;
            head = p1;
            if (p1 == null) {
                return head;
            }
        }
        p1 = p1.next;
        ListNode p2 = head;
        while (p1 != null) {
            if (p1.val == val) {
                p2.next = p1.next;
                p1 = p2.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return head;
    }
}
