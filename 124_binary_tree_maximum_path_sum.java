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

    public int maxPathSum(TreeNode root) {
      m = root.val;

      return m;
    }

    private void recursive(TreeNode root, int i) {
      if (root == null) {
        return;
      }
      if (root.val > 0) {
        recursive(root.left, i + root.val);
        recursive(root.right, i + root.val);
      } 
    }
}
