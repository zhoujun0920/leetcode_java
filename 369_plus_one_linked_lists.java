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

  public ListNode plusOne(ListNode head) {
      recursive(head);
      if (temp == 1) {
          ListNode newHead = new ListNode(1);
          newHead.next = head;
          return newHead;
      }
      return head;
  }

  private void recursive(ListNode cur) {
      if (cur.next != null) {
          recursive(cur.next);
          cur.val += temp;
          if (cur.val > 9) {
              cur.val -= 10;
              temp = 1;
          } else {
              temp = 0;
          }
      } else {
          cur.val += 1;
          if (cur.val > 9) {
              cur.val -= 10;
              temp = 1;
          }
      }
  }
}
