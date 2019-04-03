/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        serializeF(s, root, stack);
        s += "]";
        return s;
    }

    private void serializeF(String s, TreeNode root, Stack<TreeNode> stack) {
      while (!stack.isEmpty()) {
          Stack<TreeNode> current = new Stack<>();
          while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp == null) {
              s += (s == "" ? "null" : ",null");
            } else {
              s += (s == "" ? String.valueOf(temp.val) : ("," + String.valueOf(temp.val)));
              current.push(temp.left);
              current.push(temp.right);
            }

          }
          stack.addAll(current);
      }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      char[] dataArray = data.toCharArray();
      TreeNode root = recursive(dataArray, 1);
      return root;
    }

    private TreeNode recursive(char[] data, int i) {
      if (i < data.length - 1) {
        TreeNode root = new TreeNode(Integer.valueOf(data[i]));
        root.left = recursive(data, i + 1);
        root.right = recursive(data, i + 2);
        return root;
      }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
