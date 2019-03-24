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
    List<String> results;

    public List<String> binaryTreePaths(TreeNode root) {
        results = new ArrayList<>();
        if (root == null) {
          return results;
        }
        recursive(root, "");
        return results;
    }

    private void recursive(TreeNode root, String path) {
      if (root.left == null && root.right == null) {
        results.add(path + (path == "" ? String.valueOf(root.val) : (path + "->" + String.valueOf(root.val))));
        return;
      }
      if (root.left != null && root.right != null) {
        recursive(root.left,  (path == "" ? String.valueOf(root.val) : (path + "->" + String.valueOf(root.val))));
        recursive(root.right, (path == "" ? String.valueOf(root.val) : (path + "->" + String.valueOf(root.val))));
      } else if (root.left != null) {
        recursive(root.left,  (path == "" ? String.valueOf(root.val) : (path + "->" + String.valueOf(root.val))));
      } else {
        recursive(root.right, (path == "" ? String.valueOf(root.val) : (path + "->" + String.valueOf(root.val))));
      }
    }
}

class Solution {
    List<String> results;

    public List<String> binaryTreePaths(TreeNode root) {
        results = new ArrayList<>();
        if (root == null) {
          return results;
        }
        if (root.left != null && root.right != null) {
          recursive(root.left, String.valueOf(root.val));
          recursive(root.right, String.valueOf(root.val));
        } else if (root.left != null) {
          recursive(root.left, String.valueOf(root.val));
        } else if (root.right != null) {
          recursive(root.right, String.valueOf(root.val));
        } else {
          results.add(String.valueOf(root.val));
        }
        return results;
    }

    private void recursive(TreeNode root, String path) {
      if (root.left == null && root.right == null) {
        results.add(path + "->" + String.valueOf(root.val));
        return;
      }
      if (root.left != null && root.right != null) {
        recursive(root.left, path + "->" + String.valueOf(root.val));
        recursive(root.right, path + "->" + String.valueOf(root.val));
      } else if (root.left != null) {
        recursive(root.left, path + "->" + String.valueOf(root.val));
      } else if (root.right != null) {
        recursive(root.right, path + "->" + String.valueOf(root.val));
      }
    }
}
