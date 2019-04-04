class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
      ListNode cur = head;
      int i = 1;
      while (i < m - 1) {
        i++;
        cur = cur.next;
        if (cur == null) {
          return head;
        }
      }
      ListNode p1;
      if (m == 1) { // if start from begining
         p1 = cur;
      } else {
         i++;
         p1 = cur.next;
      }
      if (p1 == null) {
         return head;
      }
      ListNode p2 = p1.next;
      if (p2 == null) {
          return head;
      }
      ListNode p3 = p2.next;
      while (i < n) {
          p2.next = p1;
          p1 = p2;
          p2 = p3;
          if (p3 == null) {
              if (m == 1) { // if start from begining
                  cur.next = null;
                  return p1;
              }
              ListNode temp = cur.next;
              cur.next = p1;
              temp.next = null;
              return head;
          }
          i++;
          p3 = p3.next;
      }
      ListNode temp;
      if (m == 1) { // if start from begining
        cur.next = p2;
        return p1;
      } else {
        temp = cur.next;
        cur.next = p1;
        temp.next = p2;
      }
      return head;
    }
}

// 1->2->3->4->5->NULL
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

    }

    private ListNode recursive() {
      
    }
}
