class Solution {
    public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {
        List<Integer> result = new LinkedList<>();
        if (wizards == null && wizards.size() == 0) {
          return result;
        }
        int n = wizards.size();
        int[] parent = new int[n];
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>( (a, b) -> a[1] - b[1]);
        int[] start = {source, 0};
        queue.add(start);
        while (!queue.isEmpty()) {
          int[] current = queue.poll();
          for (Integer neighbor : wizards.get(current[0])) {
            int next = memo[neighbor];
            int weight = (current[0] - next) * (current[0] - next);
            if (weight + current[1] < next) {
              parent[neighbor = current[0];
              queue.remove(next);
              next = weight + current[1];
              queue.add(next);
            }
          }
        }

        int t = target
        while (t != source) {
          result.add(t);
          t = parent[t];
        }
        Collections.reverse(result);
        return result;
    }
}
