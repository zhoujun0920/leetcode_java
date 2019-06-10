class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> hm = new HashMap<>();
      for (int i : nums) {
        int count = hm.getOrDefault(i, 0);
        hm.put(i, count + 1);
      }
      PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> hm.get(x) - hm.get(y));
      for (int i : hm.keySet()) {
        queue.add(i);
          if (queue.size() > k) {
              queue.poll();
          }
      }
        List<Integer> result = new LinkedList();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

    Collections.reverse(result);
    return result;
    }
}
