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
      public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = recursive(nums, 0, nums.length - 1);
        return root;
      }

      private TreeNode recursive(int[] nums, int i, int j) {
        if (i <= j) {
          int mid = (i + j) / 2;
          TreeNode root = new TreeNode(nums[mid]);
          root.left = recursive(nums, i, mid -1);
          root.right = recursive(nums, mid + 1, j);
          return root;
        }
        return null;
      }
}
