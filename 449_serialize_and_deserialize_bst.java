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
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> current = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    s.append((s.length() == 0 ? "n" : ",n"));
                } else {
                    current.add(temp.left);
                    current.add(temp.right);
                    if (s.length() > 0) {
                        s.append(",");
                    }
                    s.append(String.valueOf(temp.val));
                }
            }
            queue.addAll(current);
        }
        while (true) {
            int index = s.length() - 1;
            if (s.charAt(index) == 'n') {
                s.deleteCharAt(index);
                if (s.length() > 0) {
                    s.deleteCharAt(index - 1);
                }
                if (s.length() == 0) {
                    break;
                }
            } else {
                break;
            }
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] dataArray = data.split(",");
        int length = dataArray.length;
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(dataArray[index++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> current = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (index < length && dataArray[index].equals("n")) {
                    index++;
                } else {
                    if (index < length) {
                        temp.left = new TreeNode(Integer.valueOf(dataArray[index++]));
                        current.offer(temp.left);
                    }
                }
                if (index < length && dataArray[index].equals("n")) {
                    index++;
                } else {
                    if (index < length) {
                        temp.right = new TreeNode(Integer.valueOf(dataArray[index++]));
                        current.offer(temp.right);
                    }

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
