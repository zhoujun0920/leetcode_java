
// find all Leaves
// move one step close to root together
// last one or two is the MHT
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }
      List<Set<Integer>> temp = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        temp.add(new HashSet<>());
      }
      for (int i = 0; i < edges.length; i++) {
        temp.get(edges[i][0]).add(edges[i][1]);
        temp.get(edges[i][1]).add(edges[i][0]);
      }
      List<Integer> leaves = new ArrayList<>();
      for (int i = 0; i < temp.size(); i++) {
        if (temp.get(i).size() == 1) {
          leaves.add(i);
        }
      }
      while (n > 2) {
        n -= leaves.size();
        List<Integer> newLeaves = new ArrayList<>();
        for (int i = 0; i < leaves.size(); i++) {
          int index = leaves.get(i);
          Integer s = temp.get(index).iterator().next();
          temp.get(s).remove(index);
          if (temp.get(s).size() == 1) {
            newLeaves.add(s);
          }
        }
        leaves = newLeaves;
      }
      return leaves;
    }
}
