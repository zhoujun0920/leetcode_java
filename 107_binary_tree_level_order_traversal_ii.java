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
    List<List<Integer>> results;
    Queue<TreeNode> stack;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      results = new LinkedList<>();
      stack = new LinkedList<>();
      if (root == null) {
        return results;
      }
      stack.push(root);
      recursive(root);
      return results;
    }

    private void recursive(TreeNode root) {
      while (stack.size() > 0) {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> current = new LinkedList<>();
        while (stack.size() > 0) {
          TreeNode temp = stack.poll();
          result.add(temp.val);
          if (temp.left != null) {
            current.add(temp.left);
          }
          if (temp.right != null) {
            current.add(temp.right);
          }
        }
        stack.addAll(current);
        results.add(0, result);
      }
    }
}

// Queue LinkedList
// poll add
