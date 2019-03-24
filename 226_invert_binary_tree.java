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
    public TreeNode invertTree(TreeNode root) {
      if (root == null) {
        return root;
      }
      recursive(root);
      return root;
    }

    private void recursive(TreeNode root) {
      if (root.left != null && root.right != null) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        recursive(root.left);
        recursive(root.right);
      } else if (root.left != null) {
        root.right = root.left;
        root.left = null;
        recursive(root.right);
      } else if (root.right != null) {
        root.left = root.right;
        root.right = null;
        recursive(root.left);
      }
    }
}
