/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      help(l1, l2);
      return l1;
    }

    private void help(ListNode l1, ListNode l2) {
      if (l1.next != null && l2.next != null) {
        help(l1.next, l2.next);
      } else if (l1.next != null) {
        help(l1.next, l2)
      } else if (l2.next != null) {
        help(l1, l2.next);
      }
      int temp = l1.val + l2.val + carry;
      if (temp > 9) {
        temp -= 10;
        carry = 1;
      } else {
        carry = 0;
      }
      l1.val = temp;
    }
}


class Solution {
    int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = getLength(l1);
        int size2 = getLength(l2);
        if (size1 == 0) {
            return l2;
        }
        if (size2 == 0) {
            return l1;
        }
        if (size1 >= size2) {
            help(l1, l2, size1 - size2);
            if (carry > 0) {
                ListNode temp = new ListNode(1);
                temp.next = l1;
                return temp;
            }
            return l1;
        } else {
            help(l2, l1, size2 - size1);
            if (carry > 0) {
                ListNode temp = new ListNode(1);
                temp.next = l2;
                return temp;
            }
            return l2;
        }
    }

    private void help(ListNode l1, ListNode l2, int offset) {
        if (offset > 0) {
            help(l1.next, l2, offset - 1);
            if (carry == 0) {
                return;
            }
            l1.val += carry;
            if (l1.val > 9) {
                l1.val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
        } else {
            if (l1.next != null) {
                help(l1.next, l2.next, offset);
            }
            l1.val += (l2.val + carry);
            if (l1.val > 9) {
                l1.val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
        }
    }

    private int getLength(ListNode l) {
        int count = 0;
        while(l != null) {
            l = l.next;
            count++;
        }
        return count;
    }
}

class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int size1 = getLength(l1);
      int size2 = getLength(l2);
      ListNode head = new ListNode(1);
      // Make sure l1.length >= l2.length
      head.next = size1 < size2 ? helper(l2, l1, size2 - size1) : helper(l1, l2, size1 - size2);
      // Handle the first digit
      if (head.next.val > 9) {
          head.next.val = head.next.val % 10;
          return head;
      }
      return head.next;
  }
  // get length of the list
  public int getLength(ListNode l) {
      int count = 0;
      while(l != null) {
          l = l.next;
          count++;
      }
      return count;
  }
  // offset is the difference of length between l1 and l2
  public ListNode helper(ListNode l1, ListNode l2, int offset) {
      if (l1 == null) return null;
      // check whether l1 becomes the same length as l2
      ListNode result = offset == 0 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
      ListNode post = offset == 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset - 1);
      // handle carry
      if (post != null && post.val > 9) {
          result.val += 1;
          post.val = post.val % 10;
      }
      // combine nodes
      result.next = post;
      return result;
  }
}
