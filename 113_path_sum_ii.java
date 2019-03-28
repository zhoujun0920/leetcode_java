/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Using LinkedList could be faster
class Solution {
    List<List<Integer>> results;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      results = new ArrayList<>();
      if (root == null) {
          return results;
      }
      recursive(root, sum, 0, new ArrayList<>());
      return results;
    }

    private void recursive(TreeNode root, int sum, int total, List<Integer> path) {
      if (root.left == null && root.right == null) {
        if (sum == total + root.val) {
          List<Integer> tempPath = new ArrayList<>(path);
          tempPath.add(root.val);
          results.add(tempPath);
        }
      } else if (root.left != null && root.right != null) {
        List<Integer> tempPath1 = new ArrayList<>(path);
        tempPath1.add(root.val);
        recursive(root.left, sum, total + root.val, tempPath1);
        List<Integer> tempPath2 = new ArrayList<>(path);
        tempPath2.add(root.val);
        recursive(root.right, sum, total + root.val, tempPath2);
      } else if (root.left != null) {
        List<Integer> tempPath = new ArrayList<>(path);
        tempPath.add(root.val);
        recursive(root.left, sum, total + root.val, tempPath);
      } else {
        List<Integer> tempPath = new ArrayList<>(path);
        tempPath.add(root.val);
        recursive(root.right, sum, total + root.val, tempPath);
      }
    }
}

class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum){
    List<List<Integer>> result  = new LinkedList<List<Integer>>();
    List<Integer> currentResult  = new LinkedList<Integer>();
    pathSum(root,sum,currentResult,result);
    return result;
  }

  public void pathSum(TreeNode root, int sum, List<Integer> currentResult,
      List<List<Integer>> result) {

    if (root == null)
      return;
    currentResult.add(new Integer(root.val));
    if (root.left == null && root.right == null && sum == root.val) {
      result.add(new LinkedList(currentResult));
      currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
      return;
    } else {
      pathSum(root.left, sum - root.val, currentResult, result);
      pathSum(root.right, sum - root.val, currentResult, result);
    }
    currentResult.remove(currentResult.size() - 1);
  }
}



class Solution {
    List<List<Integer>> results;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      results = new LinkedList<>();
      recursive(root, sum, 0);
      return results;
    }

    private void recursive(TreeNode root, int sum, int total, List<Integer> current) {
      if (root == null) {
        return;
      }
      current.add(root.val);
      if (root.left == null && root.right == null && total + root.val == sum) {
        List<Integer> result = new LinkedList<>(current);
        results.add(result);
        current.remove(current.size() - 1);
        return;
      } else {
        recursive(root.left, sum, total + root.val, current);
        recursive(root.right, sum, total + root.val, current);
      }
      current.remove(current.size() - 1);
    }
}
