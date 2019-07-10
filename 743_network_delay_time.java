class Solution {

  public int networkDelayTime(int[][] times, int N, int K) {
      Map<Integer, Set<int[]>> map = new HashMap<>();
      int[] parent = new int[N + 1];
      int[][] memo = new int[N + 1][2];
      for (int[] time : times) {
        Set<int[]> set = map.getOrDefault(time[0], new HashSet<>());
        int[] temp = {time[1], time[2]};
        set.add(temp);
        map.put(time[0], set);
      }
      for (int i = 1; i <= N; i++) {
          memo[i][0] = i;
          memo[i][1] = Integer.MAX_VALUE;
      }
      PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[1] - b[1]);
      memo[K][1] = 0;
      pq.add(memo[K]);
      while (!pq.isEmpty()) {
        int[] current = pq.poll();
        if (map.containsKey(current[0])) {
          for (int[] neighbor : map.get(current[0])) {
            int[] next = memo[neighbor[0]];
            if (neighbor[1] + current[1] < next[1]) {
              pq.remove(next);
              next[1] = neighbor[1] + current[1];
              pq.add(next);
              parent[next[0]] = current[0];
            }
          }
        }
      }
      int m = -1;
      for (int[] i : memo) {
        if (i[1] == Integer.MAX_VALUE) {
          return -1;
        }
        if (i[1] > m) {
          m = i[1];
        }
      }
      return m;
  }

}


class Solution {
    Map<Integer, Integer> dist;
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }
        for (int node: graph.keySet()) {
            Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);
        }
        dist = new HashMap();
        for (int node = 1; node <= N; ++node)
            dist.put(node, Integer.MAX_VALUE);

        dfs(graph, K, 0);
        int ans = 0;
        for (int cand: dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }

    public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
        if (elapsed >= dist.get(node)) return;
        dist.put(node, elapsed);
        if (graph.containsKey(node))
            for (int[] info: graph.get(node))
                dfs(graph, info[1], elapsed + info[0]);
    }
}


class Solution {

        Map<Integer, Integer> result;
        Map<Integer, List<int[]>> map;

        public int networkDelayTime(int[][] times, int N, int K) {
            result = new HashMap<>();
            map = new HashMap<>();
            for (int[] time : times) {
                List<int[]> list = map.getOrDefault(time[0], new LinkedList<>());
                int[] l = {time[1], time[2]};
                list.add(l);
                map.put(time[0], list);
            }
            if (!map.containsKey(K)) {
                return -1;
            }
            for (int i = 1; i <= N; i++) {
                result.put(i, Integer.MAX_VALUE);
            }
            result.put(K, 0);
            for (int[] node : map.get(K)) {
                help(node, 0);
            }
            int m = -1;
            for (int i = 1; i <= N; i++) {
                if (result.get(i) == Integer.MAX_VALUE) {
                    return -1;
                }
                m = m > result.get(i) ? m : result.get(i);
            }
            return m;
        }

        private void help(int[] node, int count) {
            if (result.containsKey(node[0])) {
                int temp = result.get(node[0]);
                if (temp > (count + node[1])) {
                    result.put(node[0], count + node[1]);
                } else {
                    return;
                }
            } else {
                result.put(node[0], count + node[1]);
            }
            if (map.containsKey(node[0])) {
                for (int[] time : map.get(node[0])) {
                    help(time, result.get(node[0]));
                }
            }
        }
    }
