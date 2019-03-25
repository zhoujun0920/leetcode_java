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
    Queue<TreeNode> queue;

    public List<Integer> rightSideView(TreeNode root) {
      results = new LinkedList<>();
      queue = new LinkedList<>();
        if (root == null) {
            return results;
        }
      queue.add(root);
      recursive(root, 0);
      return results;
    }

    private void recursive(TreeNode root, int i) {
      while (queue.size() > 0) {
        Queue<TreeNode> current = new LinkedList<>();
        while (queue.size() > 0) {
          TreeNode temp = queue.remove();
          if (results.size() == i) {
            results.add(temp.val);
          }
            if (temp.right != null) {
            current.add(temp.right);
          }
          if (temp.left != null) {
            current.add(temp.left);
          }
        }
        i++;
        queue.addAll(current);
      }
    }
}
