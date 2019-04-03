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

    public int closestValue(TreeNode root, double target) {
      int ret = root.val;
      while(root != null){
       if(Math.abs(target - root.val) < Math.abs(target - ret)){
           ret = root.val;
       }
       root = root.val > target? root.left: root.right;
      }
      return ret;
    }
}


// root = [4,2,5,1,3], target = 3.714286
// Output: 4
