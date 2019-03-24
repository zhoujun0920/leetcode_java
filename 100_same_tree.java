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
    public boolean isSameTree(TreeNode p, TreeNode q) {
      return recursive(p, q);
    }

    private boolean recursive(TreeNode p, TreeNode q) {
      if (p != null && q != null) {
        if (p.val != q.val) {
          return false;
        }
        return recursive(p.left, q.left) && recursive(p.right, q.right);
      } else if (p == null && q == null) {
        return true;
      }
      return false;
    }
}
