/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null) {
            while (p1 != null && p1.val == p2.val) {
                p1 = p1.next;
            }
            p2.next = p1;
            p2 = p1;
        }
        return head;
    }
}
