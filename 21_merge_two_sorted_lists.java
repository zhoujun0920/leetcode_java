/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
