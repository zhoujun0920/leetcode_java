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

    public List<Integer> preorderTraversal(TreeNode root) {
      results = new ArrayList<>();
      traversal(root);
      return results;
    }

    private void traversal(TreeNode root) {
      if (root == null) {
        return;
      }
      results.add(root.val);
      traversal(root.left);
      traversal(root.right);
    }
}

// root left right
