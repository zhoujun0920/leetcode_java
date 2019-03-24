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

    public int longestConsecutive(TreeNode root) {
      if (root == null) {
        return m;
      }
      recursive(root, 1);
      return m;
    }

    private void recursive(TreeNode root, int i) {
      if (root != null) {
        m = m > i ? m : i;
        if (root.left != null) {
          if (root.val == root.left.val - 1) {
            recursive(root.left, i + 1);
          } else {
            recursive(root.left, 1);
          }
        }
        if (root.right != null) {
          if (root.val == root.right.val - 1) {
            recursive(root.right, i + 1);
          } else {
            recursive(root.right, 1);
          }
        }
      }
    }
}
