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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      LinkedHashMap<TreeNode, Integer> map1 = new LinkedHashMap<>();
      LinkedHashMap<TreeNode, Integer> map2 = new LinkedHashMap<>();
      recursive(root, p, map1);
      recursive(root, q, map2);
      List<TreeNode> keyList = new ArrayList<TreeNode>(map1.keySet());
      for (int i = map1.size() - 1; i >= 0; i--) {
        TreeNode temp = keyList.get(i);
        if (map2.containsKey(temp)) {
          return temp;
        }
      }
      return null;
    }

    private void recursive(TreeNode root, TreeNode p, LinkedHashMap<TreeNode, Integer> map) {
      if (root == null) {
        return;
      }
      map.put(root, 1);
      if (p.val > root.val) {
        recursive(root.right, p, map);
      } else if (p.val < root.val) {
        recursive(root.left, p, map);
      } else {
        return;
      }
    }
}

// The split point is the lowest common ancestor, no need to find the node.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      // Value of current node or parent node.
        int parentVal = root.val;

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }
}
