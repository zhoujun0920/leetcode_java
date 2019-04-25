/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 class Solution {

     ListNode myHead;
     Random rand = new Random();
     int length = 0;

     /** @param head The linked list's head.
         Note that the head is guaranteed to be not null, so it contains at least one node. */
     public Solution(ListNode head) {
         myHead = head;
         ListNode current = head;
         while (current != null) {
             current = current.next;
             length++;
         }
     }

     /** Returns a random node's value. */
     public int getRandom() {
         int r = rand.nextInt(length);
         int temp = 0;
         ListNode current = myHead;
         while (temp < r) {
             temp++;
             current = current.next;
         }
         return current.val;
     }
 }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
