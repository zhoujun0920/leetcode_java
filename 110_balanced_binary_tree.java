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
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
      recursive(root);
      return isBalanced;
    }

    private int recursive(TreeNode root) {
      if (isBalanced) {
        if (root == null) {
          return 0;
        }
        if (root.left == null && root.right == null) {
          return 1;
        }
        int left = recursive(root.left);
        int right = recursive(root.right);
        if (left <= right + 1 && left >= right - 1) {
          if (left > right) {
            return 1 + left;
          } else {
            return 1 + right;
          }
        } else {
          isBalanced = false;
          return 0;
        }
      } else {
        return 0;
      }
    }
}
