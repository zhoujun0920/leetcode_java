/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
      ListNode fast = head;
      ListNode slow = head;
        if (head == null) {
            return;
        }
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }
      ListNode end = slow;
      Stack<ListNode> stack = new Stack<>();
      while (slow.next != null) {
          stack.push(slow.next);
          slow = slow.next;
      }
        ListNode start = head;
      while (!stack.isEmpty()) {
          ListNode temp = stack.pop();
          temp.next = start.next;
          start.next = temp;
          start = temp.next;
      }
      end.next = null;
    }
}


// find the mid point reverse the half list
class Solution {
    public void reorderList(ListNode head) {

    }

    private ListNode reverse(ListNode head) {

    }
}
