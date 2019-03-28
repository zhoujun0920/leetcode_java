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
    TreeNode n1;
    TreeNode n2;
    TreeNode previous;

    public void recoverTree(TreeNode root) {
      n1 = null;
      n2 = null;
      previous = new TreeNode(Integer.MIN_VALUE);
      recursive(root);
      swap(n1, n2);
    }

    private void recursive(TreeNode root) {
      if (root == null) {
        return;
      }
      recursive(root.left);
      // find two Element
      if (n1 == null && previous.val >= root.val) {
        n1 = previous;
      }
      if (n1 != null && previous.val >= root.val) {
        n2 = root;
      }
      previous = root;
      recursive(root.right);
    }

    private void swap(TreeNode n1, TreeNode n2) {
      int temp = n1.val;
      n1.val = n2.val;
      n2.val = temp;
    }
}
