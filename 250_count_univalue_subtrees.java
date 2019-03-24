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

    public int countUnivalSubtrees(TreeNode root) {
     recursive(root);
      return m;
    }

    private boolean recursive(TreeNode root) {
      if (root == null) {
        return true;
      }
      if (root.left == null && root.right == null) {
        m += 1;
        return true;
      }
      if (recursive(root.left) & recursive(root.right)) {
        if (root.left != null && root.right != null) {
          if (root.left.val == root.val && root.right.val == root.val) {
              m += 1;
              return true;
          }
        } else if (root.left != null) {
          if (root.left.val == root.val) {
            m += 1;
            return true;
          }
        } else if (root.right != null) {
          if (root.right.val == root.val) {
            m += 1;
            return true;
          }
        }
      }
      return false;
    }
}
