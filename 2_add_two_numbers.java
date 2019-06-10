/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 class Solution {
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode root = l1;
         int carry = 0;
         ListNode previous = l1;
         while (l1 != null && l2 != null) {
             int temp = l1.val + l2.val + carry;
             if (temp > 9) {
                 temp -= 10;
                 carry = 1;
             } else {
                 carry = 0;
             }
             l1.val = temp;
             previous = l1;
             l1 = l1.next;
             l2 = l2.next;
         }
         if (l1 == null) {
             previous.next = l2;
             l1 = previous.next;
         }
         while (l1 != null && carry == 1) {
             l1.val += carry;
             if (l1.val > 9) {
                 l1.val -= 10;
                 previous = l1;
                 l1 = l1.next;
             } else {
                 carry = 0;
                 break;
             }
         }
         if (carry == 1) {
             ListNode node = new ListNode(1);
             previous.next = node;
         }
         return root;
     }
 }


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
