/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        int i = 1;
        if (n == 1) {
            p1 = p1.next;
            if (p1 == null) {
                head = null;
                return head;
            }
        } else {
           while (p1 != null && i < n) {
            p1 = p1.next;
            i++;
           }
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (n == 1) {
            p2.next = null;
            return head;
        }
        p2.val = p2.next.val;
        p2.next = p2.next.next;
        return head;
    }
}
