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
    List<Integer> results;

    public List<Integer> postorderTraversal(TreeNode root) {
        results = new ArrayList<>();
        traversal(root);
        return results;
    }

    private void traversal(TreeNode root) {
      if (root == null) {
        return;
      }
      traversal(root.left);
      traversal(root.right);
      results.add(root.val);
    }
}


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> results = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      if (root != null) {
        stack.push(root);
      }
      while (stack.size() > 0) {
        TreeNode temp = stack.peek();
        if (temp.left != null) {
          stack.push(temp.left);
          continue;
        }
        if (temp.right != null) {
          stack.push(temp.right);
          continue;
        }
        TreeNode result = stack.pop();
        results.add(result.val);
      }
      return results;
    }
}

// left right root

// LinkedList
// ArrayList
// Queue
// Deque
// Stack
// HashMap
// HashSet
// LinkedHashMap maintain the order
// LinkedHashSet maintain the order
// TreeSet ceiling floor
// TreeMap ceilingEntry floorEntry
