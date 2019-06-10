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

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> parents = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> current = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                TreeNode parent = parents.poll();
                if (temp.val == x || temp.val == y) {
                    while (!queue.isEmpty()) {
                        temp = queue.poll();
                        TreeNode parent2 = parents.poll();
                        if (temp.val == x || temp.val == y) {
                            return parent != parent2;
                        }
                    }
                    return false;
                }
                if (temp.left != null) {
                    current.add(temp.left);
                    parents.add(temp);
                }
                if (temp.right != null) {
                    current.add(temp.right);
                    parents.add(temp);
                }
            }
            queue.addAll(current);
        }
        return false;
    }

}
