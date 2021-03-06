/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode reverseList(ListNode head) {
      ListNode p1 = head;
      if (p1 == null) {
          return head;
      }
      ListNode p2 = p1.next;
      if (p2 == null) {
          return head;
      }
      ListNode p3 = p2.next;
      p1.next = null;
      while (p3 != null) {
        p2.next = p1;
        p1 = p2;
        p2 = p3;
        p3 = p3.next;
      }
      p2.next = p1;
      return p2;
  }
}

public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}
