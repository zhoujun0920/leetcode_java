class Solution {
    public int countComponents(int n, int[][] edges) {

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < edges.length; i++) {
            int xSet = find(parent, edges[i][0]);
            int ySet = find(parent, edges[i][1]);

            if (xSet == ySet) {
                continue;
            }

            parent[xSet] = ySet;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1) return i;
        return find(parent, parent[i]);
    }
}


class Solution {

    Map<Integer, Set<Integer>> map;
    Set<Integer> visited;

    public int countComponents(int n, int[][] edges) {
      map = new HashMap<>();
      visited = new HashSet<>();
      for (int[] edge : edges) {
        Set<Integer> set = map.getOrDefault(edge[0], new HashSet<>());
        set.add(edge[1]);
        map.put(edge[0], set);
        Set<Integer> set2 = map.getOrDefault(edge[1], new HashSet<>());
        set2.add(edge[0]);
        map.put(edge[1], set2);
      }
      int count = 0;
      for (int i = 0; i < n; i++) {
          if (visited.add(i)) {
              dfsVisit(i);
              count++;
          }
      }
      return count;
    }

    private void dfsVisit(int i) {
      if (map.containsKey(i)) {
          for (int j : map.get(i)) {
              if (visited.add(j)) {
                dfsVisit(j);
              }
          }
      }
    }
}
