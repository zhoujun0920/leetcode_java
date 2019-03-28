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
      while(!queue.isEmpty()) {
        List<Node> current = new LinkedList<>();
        while(!current.isEmpty()) {
          Node temp = queue.remove();
          if (temp.left != null) {
            current.add(temp.left);
          }
          if (temp.right != null) {
            current.add(temp.right);
          }
        }
        for (int i = 0; i < current.size(); i++) {
          if (i == current.size() - 1) {
                current.get(current.size() - 1).next = null;
            } else {
                current.get(i).next = current.get(i + 1);
            }
        }
        queue.addAll(current);
      }
      return root;
    }
}

class Solution {
    public Node connect(Node root) {
      if (root == null) {
        return root;
      }
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      while(!queue.isEmpty()) {
        Deque<Node> current = new LinkedList<>();
			while(!queue.isEmpty()) {
				Node temp = queue.remove();
                if (current.size() > 0) {
                    Node previous = current.getLast();
                    previous.next = temp.left;
                }
                if (temp.left != null) {
                    current.add(temp.left);
                    current.add(temp.right);
                    temp.left.next = temp.right;
                    temp.right.next = null;
                }
			}
        queue.addAll(current);
      }
      return root;
    }
}
