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
    TreeMap<Integer, List<Integer>> map;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        map = new TreeMap<>();
        recursive(root, 0);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private void recursive(TreeNode root, int distance) {
        List<Integer> list = map.getOrDefault(distance, new LinkedList<>());
        list.add(root.val);
        map.put(distance, list);
        if (root.left != null) {
            recursive(root.left, distance - 1);
        }
        if (root.right != null) {
          recursive(root.right, distance + 1);
        }
    }
}


class Solution {
    TreeMap<Integer, List<Integer>> map;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        
    }
}
