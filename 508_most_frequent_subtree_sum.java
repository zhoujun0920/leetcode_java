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

     class Node {
         int val;
         int count;

         Node(int val, int count) {
             this.val = val;
             this.count = count;
         }
     }

     Map<Integer, Integer> map;

     public int[] findFrequentTreeSum(TreeNode root) {
         map = new HashMap<>();
         help(root);
         PriorityQueue<Node> queue = new PriorityQueue<>( (a, b) -> b.count - a.count );
         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
             queue.add(new Node(entry.getKey(), entry.getValue()));
         }
         int m = Integer.MIN_VALUE;
         List<Node> list = new LinkedList<>();
         while (!queue.isEmpty()) {
             Node temp = queue.poll();
             if (m > temp.count) {
                 break;
             } else {
                 m = temp.count;
                 list.add(temp);
             }
         }
         int[] result = new int[list.size()];
         for (int i = 0; i < list.size(); i++) {
             result[i] = list.get(i).val;
         }
         return result;

     }

     private int help(TreeNode root) {
         if (root == null) {
             return 0;
         }
         int left = help(root.left);
         int right = help(root.right);
         int sum = root.val + left + right;
         int count = map.getOrDefault(sum, 0);
         map.put(sum, count + 1);
         return sum;
     }
 }
