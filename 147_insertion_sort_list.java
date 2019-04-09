/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode sorted = new ListNode(0);
        sorted.next = head; // insert first to sorted
        ListNode cur = head.next; //current is second
        head.next = null; //break the first link
        while (cur != null) {
            ListNode curSorted = sorted.next;
            ListNode pre = sorted;
            boolean found = false;
            while (curSorted != null && cur.val > curSorted.val) {
                pre = pre.next;
                curSorted = curSorted.next;
                if (curSorted == null) {
                    ListNode temp = cur.next;
                    pre.next = cur;
                    cur.next = null; // break the link if insert to the end
                    cur = temp;
                    found = true;
                }
            }
            if (!found) {
                ListNode temp = cur.next;
                pre.next = cur;
                cur.next = curSorted;
                cur = temp;
            }
        }
        return sorted.next;
    }

}
