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
    public boolean isSymmetric(TreeNode root) {
      if (root == null) {
        return true;
      }
      return recursive(root.left, root.right);
    }

    private boolean recursive(TreeNode p, TreeNode q) {
      if (p != null && q != null) {
        if (p.val != q.val) {
          return false;
        }
        return recursive(p.left, q.right) && recursive(p.right, q.left);
      } else if (p == null && q == null) {
        return true;
      }
      return false;
    }
}
