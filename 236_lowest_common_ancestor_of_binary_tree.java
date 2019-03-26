/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    LinkedHashMap<Integer, TreeNode> map1 = new LinkedHashMap<>();
    LinkedHashMap<Integer, TreeNode> map2 = new LinkedHashMap<>();
    recursive(root, p, map1);
    recursive(root, q, map2);
    List<Integer> keyList = new ArrayList<Integer>(map1.keySet());
    for (int i = map1.size() - 1; i >= 0; i--) {
      Integer temp = keyList.get(i);
      if (map2.containsKey(temp)) {
        return map2.get(temp);
      }
    }
    return null;
  }

  private boolean recursive(TreeNode root, TreeNode p, LinkedHashMap<Integer, TreeNode> map) {
    if (root == null) {
      return false;
    }
    map.put(root.val, root);
    if (p.val == root.val) {
      return true;
    }
    if (recursive(root.left, p, map)) {
      return true;
    } else if (recursive(root.right, p, map)) {
      return true;
    } else {
      map.remove(root.val);
      return false;
    }
  }
}

// is left found, is right found, is current found
// two of them satisfied
// all node are unique
class Solution {
      private TreeNode ans;

      public Solution() {
          // Variable to store LCA node.
          this.ans = null;
      }

      private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

          // If reached the end of a branch, return false.
          if (currentNode == null) {
              return false;
          }

          // Left Recursion. If left recursion returns true, set left = 1 else 0
          int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

          // Right Recursion
          int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

          // If the current node is one of p or q
          int mid = (currentNode == p || currentNode == q) ? 1 : 0;


          // If any two of the flags left, right or mid become True
          if (mid + left + right >= 2) {
              this.ans = currentNode;
          }

          // Return true if any one of the three bool values is True.
          return (mid + left + right > 0);
      }

      public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          // Traverse the tree
          this.recurseTree(root, p, q);
          return this.ans;
      }
}
