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
    int m = 0;

    public int minDepth(TreeNode root) {
      if (root == null) {
        return m;
      }
      recursive(root, 1);
      return m;
    }

    private void recursive(TreeNode root, int i) {
      if (root.left == null && root.right == null) {
        m = i;
        return;
      }
      if (m == 0 || i < m) {
        if (root.left != null) {
          recursive(root.left, i + 1);
        }
        if (root.right != null) {
          recursive(root.right, i + 1);
        }
      }
    }
}
