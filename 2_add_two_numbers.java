/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  int temp = 0;

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      recursive(l1, l2);
      return l1;
  }

  private void recursive(ListNode l1, ListNode l2) {
      if (l1 != null && l2 != null) {
          l1.val += (l2.val + temp);
          if (l1.val > 9) {
              l1.val -= 10;
              temp = 1;
          } else {
              temp = 0;
          }
          if (l1.next != null && l2.next != null) {
              recursive(l1.next, l2.next);
          } else if (l1.next == null && l2.next == null) {
              if (temp == 1) {
                  ListNode newHead = new ListNode(1);
                  l1.next = newHead;
              }
          } else {
              if (l1.next == null) {
                  l1.next = l2.next;
              }
              recursive(l1.next, null);
          }
      } else if (temp == 1) {
          l1.val += 1;
          if (l1.val > 9) {
              l1.val -= 10;
              temp = 1;
          } else {
              temp = 0;
          }
          if (temp == 1 && l1.next == null) {
              ListNode newHead = new ListNode(1);
              l1.next = newHead;
          } else {
              recursive(l1.next, null);
          }
      }
  }
}
