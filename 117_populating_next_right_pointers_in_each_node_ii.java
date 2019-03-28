/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
      if (root == null) {
        return root;
      }
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        Deque<Node> current = new LinkedList<>();
        while (!queue.isEmpty()) {
          Node temp = queue.remove();
          if (temp.left != null) {
            if (!current.isEmpty()) {
              Node previous = current.getLast();
              previous.next = temp.left;
            }
            current.add(temp.left);
            if (temp.right != null) {
              current.add(temp.right);
              temp.left.next = temp.right;
              temp.right.next = null;
            }
          } else if (temp.right != null) {
            if (!current.isEmpty()) {
              Node previous = current.getLast();
              previous.next = temp.right;
            }
            current.add(temp.right);
          }
        }
        queue.addAll(current);
      }
      return root;
    }
}
