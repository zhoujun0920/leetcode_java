/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) { // empty case
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while (i < k) {
            i++;
            if (fast.next == null) { // if k is large
                k = k % i;
                i = 0;
                fast = head;
            } else {
                fast = fast.next;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;
        return newHead;
    }
}
