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
    List<Integer> result;
    boolean found;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
      result = new LinkedList<>();
      dfs(root, target, K);
      return result;
    }

    private void dfs(TreeNode root, TreeNode target, int K) {
      if (root == null) {
        return;
      }
      if (found && K == 0) {
        result.add(root.val);
        return;
      }
      if (root.val == target.val) {
        found = true;
      }
      if (found) {
        dfs(root.left, target, K - 1);
        dfs(root.right, target, K - 1);
      } else {
        dfs(root.left, target, K);
        if (found) {
          K--;
          dfs(root.right, target, K - 1);
        } else {
          dfs(root.right, target, K);
        }
      }
    }
}

class Solution {
    Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList();
        queue.add(target);

        Set<TreeNode> seen = new HashSet();// need it to avoid duplicates
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while (!queue.isEmpty()) {
            if (dist == K) {
                List<Integer> ans = new ArrayList();
                for (TreeNode n: queue)
                    ans.add(n.val);
                return ans;
            }
            Queue<TreeNode> current = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    current.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    current.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    current.offer(par);
                }
            }
            queue.addAll(current);
            dist++;
        }

        return new ArrayList<Integer>();
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
