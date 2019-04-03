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

  TreeMap<Double, List<Integer>> results;
  int kk = 0;

  public List<Integer> closestKValues(TreeNode root, double target, int k) {
      results = new TreeMap<>();
      List<Integer> result = new LinkedList<>();
      kk = k;
      recursive(root, target);
      for (Map.Entry<Double, List<Integer>> entry : results.entrySet()) {
          result.addAll(entry.getValue());
      }
      return result;
  }

  private void recursive(TreeNode root, double target) {
      if (root == null) {
          return;
      }
      recursive(root.left, target);
      double temp = Math.abs(target - root.val);
      if (kk > 0) {
          List<Integer> list;
          if (results.containsKey(temp)) {
              list = results.get(temp);
          } else {
              list = new LinkedList<>();
          }
          list.add(root.val);
          results.put(temp, list);
          kk--;
      } else {
          Double maxDiff = results.lastKey();
          if (maxDiff > temp) {
              List<Integer> mList = results.get(maxDiff);
              if (mList.size() == 1) {
                  results.remove(maxDiff);
              } else {
                  mList.remove(mList.size() - 1);
                  results.put(maxDiff, mList);
              }
              List<Integer> newList = new LinkedList<>();
              newList.add(root.val);
              results.put(temp, newList);
          } else if (maxDiff == temp) {
              List<Integer> mList = results.get(maxDiff);
              mList.set(mList.size() - 1, root.val);
              results.put(maxDiff, mList);
          }
      }
      recursive(root.right, target);
  }
}


class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
      
    }
}
