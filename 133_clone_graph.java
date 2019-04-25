/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    Map<Node, Node> hm = new HashMap<>();

    public Node cloneGraph(Node node) {
      if (hm.containsKey(node)) {
        return hm.get(node);
      }
      Node clone = new Node(node.val, new ArrayList<>());
      hm.put(node, clone);
      if (node.neighbors != null) {
        for (Node temp : node.neighbors) {
          Node newTemp = cloneGraph(temp);
          clone.neighbors.add(newTemp);
        }
      }
      return newHead;
    }

}
