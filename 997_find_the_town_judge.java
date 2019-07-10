class Solution {

    public int findJudge(int N, int[][] trust) {
      int[] count = new int[N + 1];
      boolean[] visited = new boolean[N + 1];
      for (int[] t : trust) {
        visited[t[0]] = true;
        count[t[1]]++;
      }
      for (int i = 1; i <= N; i++) {
        if (count[i] == N - 1) {
          if (visited[i]) {
            return -1;
          } else {
            return i;
          }
        }
      }
      return -1;
    }

}

class Solution {

    Map<Integer, Set<Integer>> map;

    public int findJudge(int N, int[][] trust) {
        map = new HashMap<>();
        for (int[] t: trust) {
            Set<Integer> set = map.getOrDefault(t[0], new HashSet<>());
            set.add(t[1]);
            map.put(t[0], set);
        }
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            help(i, visited);
        }
        for (int i = 1l i <= N; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return -1;
    }

    private void help(int i, boolean[] visited) {
        if (visited[i]) {
            return;
        }
        Set<Integer> set = map.get(i);
        if (set.size() > 0) {
            visited[i] = true;
            return;
        }
        for (int j : set) {
            help(j, visited);
        }
    }
}


//N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
