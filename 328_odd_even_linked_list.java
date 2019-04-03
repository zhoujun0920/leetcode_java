/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 // 1 2 3 4 5 6
 // 1 3 2 4 5 6
 // 1 3 5 2 4 6
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode p1 = head;
        if (p1 == null) {
            return head;
        }
        ListNode p2 = p1.next;
        if (p2 == null) {
            return head;
        }
        ListNode p3 = p2.next;
        while (p3 != null) {
            ListNode temp = p1.next;
            p2.next = p3.next;
            p1.next = p3;
            p3.next = temp;
            p1 = p3;
            p3 = p2.next;
            if (p3 == null) {
                return head;
            }
            p2 = p2.next;
            p3 = p3.next;
        }
        return head;
    }
}
