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
    Deque<TreeNode> deque;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      results = new LinkedList<>();
      deque = new LinkedList<>();
      if (root == null) {
        return results;
      }
      deque.add(root);
      recursive(root, 0);
      return results;
    }

    private void recursive(TreeNode root, int i) {
      while (deque.size() > 0) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> current = new ArrayDeque<>();
        while (deque.size() > 0) {
            TreeNode temp = deque.removeLast();
            if (i % 2 == 0) {
                if (temp.left != null) {
                    current.add(temp.left);
                }
                if (temp.right != null) {
                    current.add(temp.right);
                }
            } else {
                if (temp.right != null) {
                    current.add(temp.right);
                }
                if (temp.left != null) {
                    current.add(temp.left);
                }
            }
            result.add(temp.val);
        }
        i++;
        deque.addAll(current);
        results.add(result);
      }
}

// Deque
// Returning null + removing operations: poll()
// Throwing exception + removing operations: pop()
// removeLast()
// remove()
// removeFirst()
