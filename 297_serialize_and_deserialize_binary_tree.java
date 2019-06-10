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
      if (root == null) {
          return "";
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      StringBuilder s = new StringBuilder();
      while (!queue.isEmpty()) {
          Queue<TreeNode> current = new LinkedList<>();
          while (!queue.isEmpty()) {
              TreeNode temp = queue.poll();
              if (temp == null) {
                  s.append((s.length() == 0 ? "null" : ",null"));
              } else {
                  current.offer(temp.left);
                  current.offer(temp.right);
                  if (s.length() == 0) {
                      s.append(String.valueOf(temp.val));
                  } else {
                      s.append(",");
                  }
              }
          }
          queue.addAll(current);
      }
      return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 2) {
            return null;
        }
        String[] dataArray = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        if (dataArray.length == 0) {
            return null;
        }
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(dataArray[index++]));
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> current = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (!dataArray[index].equals("null")) {
                    temp.left = new TreeNode(Integer.valueOf(dataArray[index++]));
                    current.offer(temp.left);
                } else {
                    index++;
                }
                if (!dataArray[index].equals("null")) {
                    temp.right = new TreeNode(Integer.valueOf(dataArray[index++]));
                    current.offer(temp.right);
                } else {
                    index++;
                }
            }
            queue.addAll(current);
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
