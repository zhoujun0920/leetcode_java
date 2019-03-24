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
    int m =0;

    public int maxDepth(TreeNode root) {
      if (root == null) {
        return m;
      }
      recursive(root, 1);
      return m;
    }

    private void recursive(TreeNode root, int i) {
      if (root.left == null && root.right == null) {
        m = m > i ? m : i;
        return;
      }
      if (root.left != null) {
        recursive(root.left, i + 1);
      }
      if (root.right != null) {
        recursive(root.right, i + 1);
      }
    }
}

class Solution {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    if (left > right) {
      return left + 1;
    } else {
      return right + 1;
    }
  }
}
