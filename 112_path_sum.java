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
    boolean hasFound = false;

    public boolean hasPathSum(TreeNode root, int sum) {
      if (root == null) {
        return sum == 0;
      }
      recursive(root, sum, 0);
      return hasFound;
    }

    private void recursive(TreeNode root, int sum, int total) {
      if (!hasFound) {
        if (root.left == null && root.right == null) {
          if (sum == total + root.val) {
            hasFound = true;
          }
        } else if (root.left != null && root.right != null) {
          recursive(root.left, sum, total + root.val);
          recursive(root.right, sum, total + root.val);
        } else if (root.left != null) {
          recursive(root.left, sum, total + root.val);
        } else {
          recursive(root.right, sum, total + root.val);
        }
      }
    }
}
