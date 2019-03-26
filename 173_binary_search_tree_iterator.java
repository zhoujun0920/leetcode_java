/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    TreeNode head;
    int current = 0;
    List<Integer> values;

    public BSTIterator(TreeNode root) {
      head = root;
      values = new LinkedList<>();
      recursive(root);
    }

    private void recursive(TreeNode root) {
      if (root == null) {
        return;
      }
      recursive(root.left);
      values.add(root.val);
      recursive(root.right);
    }

    /** @return the next smallest number */
    public int next() {
      return values.get(current++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return values.size() > current;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


 class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode current = root;
        if (current != null) {
          stack.push(current);
          while (current.left != null) {
            stack.push(current.left);
            current = current.left;
          }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return stack.size() > 0;
    }

    /** @return the next smallest number */
    public int next() {
      TreeNode node = stack.pop();
      TreeNode current = node;
      if (current.right != null) {
        stack.push(current.right);
        while (current.left != null) {
          stack.push(current.left);
          current = current.left;
        }
      }
      return node.val;
    }
 }
