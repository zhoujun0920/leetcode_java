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
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> results = new ArrayList<>();
      Queue<TreeNode> queue= new LinkedList<>();
      if (root == null) {
        return results;
      }
      queue.add(root);
      while (queue.size() > 0) {
        List<Integer> row = new ArrayList<>();
        Queue<TreeNode> currentQueue = new LinkedList<>();
        while (queue.size() > 0) {
          TreeNode node = queue.poll();
          row.add(node.val);
          if (node.left != null) {
            currentQueue.add(node.left);
          }
          if (node.right != null) {
            currentQueue.add(node.right);
          }
        }
        results.add(row);
        queue.addAll(currentQueue);
      }
      return results;
  }
}

// Queue<TreeNode> queue = new LinkedList<>();
// Queue<TreeNode> queue = new ArrayDeque<>();
// queue.add();
// queue.poll();
