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

    public List<Integer> inorderTraversal(TreeNode root) {
        results = new ArrayList<>();
        traversal(root);
        return results;
    }

    private void traversal(TreeNode root) {
      if (root == null) {
        return;
      }
      traversal(root.left);
      results.add(root.val);
      traversal(root.right);
    }
}

// left root right
