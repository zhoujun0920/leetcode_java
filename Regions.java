class Solution {

  class Node {

    String val;
    Node left;
    Node right;

    public Node(String val) {
      this.val = val;
    }
  }

  Node ans;

  public void region(String[][] regions) {
    Map<String, Node> map = new HashMap<>();
    for (String[] region : regions) {
        Node root = map.getOrDefault(region[0], new Node(region[0]));
        Node left = new Node(region[1]);
        Node right = new Node(region[2]);
        root.left = left;
        root.right = right;
        map.put(region[0], root);
        map.put(region[1], left);
        map.put(region[2], right);
    }

  }

  private int help(Node root, Node p, Node q) {
    if (root == null) {
      return;
    }
    int left = help(root.left, p, q);
    int right = help(root.right, p, q);
    int mid = p.val == root.val || q.val == root.val;
    if (left + right + mid >= 2) {
      this.ans = root;
      return;
    }
    return left + right + mid;
  }
}
