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
    TreeNode result;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      stack = new Stack<>();
      recursive(root, p);
      return result;
    }

    private void recursive(TreeNode root, TreeNode p) {
      if (root == null) {
        return;
      }
      if (root.val > p.val) {
        stack.push(root); // Save the previous tree node for left tree.
        recursive(root.left, p);
      } else if (root.val < p.val) {
        recursive(root.right, p);
      } else {
        TreeNode temp = root; //current node
        if (temp.right == null) { //if current node doesn't have right node
          if (!stack.isEmpty()) {
             temp = stack.pop(); // stack not empty get the previous node
            } else {
                return; //stack empty means on the right tree
            }
          } else {
            temp = temp.right; // the successor is the leftest node of the right node
            while (temp.left != null) {
                temp = temp.left;
            }
          }
          result = temp;
          return;
      }
    }
}


// Input: root = [2,1,3], p = 1
// Output: 2

// Input: root = [5,3,6,2,4,null,null,1], p = 6
// Output: null
