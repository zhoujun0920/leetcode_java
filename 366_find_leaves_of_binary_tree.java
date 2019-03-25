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

    public List<List<Integer>> findLeaves(TreeNode root) {
      results = new LinkedList<>();
      recursive(root);
      return results;
    }

    private int recursive(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int left = recursive(root.left);
      int right = recursive(root.right);
      int height = left > right ? left : right;
      if (results.size() == height) {
        results.add(new LinkedList<>());
      }
      results.get(height).add(root.val);
      return height + 1;
    }
}
