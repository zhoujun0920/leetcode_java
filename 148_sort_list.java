/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 // O(nlogn)
 // split -> sort -> merge
class Solution {
  public ListNode sortList(ListNode head) {
      if (head == null || head.next == null) {
          return head;
      }
      ListNode fast = head;
      ListNode slow = head;
      ListNode pre = head;
      while (fast != null && fast.next != null) {
          pre = slow;
          fast = fast.next.next;
          slow = slow.next;
      }
      pre.next = null;
      ListNode leftSorted = sortList(head);
      ListNode rightSorted = sortList(slow);
      return merge(leftSorted, rightSorted);
  }

  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode head = null;
    ListNode cur = null;
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            if (head == null) {
                head = new ListNode(l1.val);
                cur = head;
            } else {
                cur.next = l1;
                cur = l1;
            }
            l1 = l1.next;
        } else {
            if (head == null) {
                head = new ListNode(l2.val);
                cur = head;
            } else {
                cur.next = l2;
                cur = l2;
            }
            l2 = l2.next;
        }
    }
    if (l1 != null) {
        if (cur == null) {
            return l1;
        }
        cur.next = l1;
        return head;
    }
    if (l2 != null) {
        if (cur == null) {
            return l2;
        }
        cur.next = l2;
        return head;
    }
    return head;
  }
}

ListNode merge(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0), p = l;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }

    if (l1 != null)
      p.next = l1;

    if (l2 != null)
      p.next = l2;

    return l.next;
  }
