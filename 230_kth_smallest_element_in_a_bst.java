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
    Stack<TreeNode> stack;
    Integer result;
    int kk;

    public int kthSmallest(TreeNode root, int k) {
      stack = new Stack<>();
      result = null;
      recursive(root);
      kk = k;
    }

    private void recursive(TreeNode root) {
      if (result == null) {
        if (root == null) {
          return;
        }
        recursive(root.left);
        stack.push(root);
        if (stack.size() == kk) {
          result = root.val;
        }
        recursive(root.right);
        stack.pop();
        kk--;
      }
    }
}


class Solution {
  Stack<TreeNode> stack;

  public int kthSmallest(TreeNode root, int k) {
    stack = new Stack<>();
    return recursive(root, k);
  }

  private int recursive(TreeNode root, int k) {
      TreeNode cur = root;
      while (cur != null) {
          stack.push(cur);
          cur = cur.left;
      }
      while (k != 1) {
          cur = stack.pop();
          if (cur.right != null) {
              cur = cur.right;
              stack.push(cur);
              while (cur.left != null) {
                  stack.push(cur.left);
                  cur = cur.left;
              }
          }
          k--;
      }
      return stack.peek().val;
  }
}
