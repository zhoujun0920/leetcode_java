/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {

  Map<Node, Node> hm = new HashMap<>();

  public Node copyRandomList(Node head) {
     if (head == null) {
          return null;
      }
      if (hm.containsKey(head)) {
        return hm.get(head);
      }
      Node newHead = new Node(head.val, null, null);
      hm.put(head, newHead);
      if (head.next != null) {
        newHead.next = copyRandomList(head.next);
      }
      if (head.random != null) {
        newHead.random = copyRandomList(head.random);
      }
      return newHead;
  }
}
