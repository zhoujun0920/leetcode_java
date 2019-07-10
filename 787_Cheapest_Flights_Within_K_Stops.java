class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
      Map<Integer, Set<int[]>> map = new HashMap<>();
      int[] memo = new int[n];
      int[] parent = new int[n];
      for (int[] flight : flights) {
        Set<int[]> set = map.getOrDefault(flight[0], new HashSet<>());
        int[] temp = {flight[1], flight[2]};
        set.add(temp);
        map.put(flight[0], set);
      }
      Arrays.fill(memo, Integer.MAX_VALUE);
      PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[1] - b[1]);
      int[] start = {src, 0, 0};
      pq.add(start);
      while (!pq.isEmpty()) {
        int[] current = pq.poll();
        if (current[0] == dst) {
          continue;
        }
        if (current[2] <= K && map.containsKey(current[0])) {
          for (int[] neighbor : map.get(current[0])) {
            if (current[1] + neighbor[1] < memo[neighbor[0]]) {
              if (current[2] + 1 > K && neighbor[0] != dst) {
                continue;
              }
              memo[neighbor[0]] = current[1] + neighbor[1];
              parent[neighbor[0]] = current[0];
              int[] next = {neighbor[0], current[1] + neighbor[1], current[2] + 1};
              pq.add(next);
            }
          }
        }
      }
      return memo[dst] == Integer.MAX_VALUE ? -1 : memo[dst];
    }
}


class Solution {
    int result;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Set<int[]>> fm = new HashMap<>();
        for (int[] flight : flights) {
            Set<int[]> set = fm.getOrDefault(flight[0], new HashSet<>());
            int[] temp = {flight[1], flight[2]};
            set.add(temp);
            fm.put(flight[0], set);
        }
        result = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        Queue<Integer> costs = new LinkedList<>();
        int[] start = {src, 0};
        queue.add(start);
        costs.add(0);
        int stops = 0;
        while(!queue.isEmpty() && stops <= K) {
            Queue<int[]> current = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                int cost = costs.poll();
                if (fm.containsKey(temp[0])) {
                    for (int[] next : fm.get(temp[0])) {
                        if (cost + next[1] < result) {
                            if (next[0] == dst) {
                                result = result > cost + next[1] ? cost + next[1] : result;
                            } else {
                                current.add(next);
                                costs.add(cost + next[1]);
                            }
                        }
                    }
                }
            }
            queue.addAll(current);
            stops++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
