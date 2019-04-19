class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> hm = new HashMap<>();
      for (int i : nums) {
        int count = hm.getOrDefault(i, 0);
        hm.put(i, count + 1);
      }
      PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
      Map<Integer, List<Integer>> hm2 = new HashMap<>();
      for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
        if (!hm2.containsKey(entry.getValue())) {
          queue.add(entry.getValue());
        }
        List<Integer> temp = hm2.getOrDefault(entry.getValue(), new LinkedList<>());
        temp.add(entry.getKey());
        hm2.put(entry.getValue(), temp);
      }
      int count = 0;
      List<Integer> result = new LinkedList<>();
      while (count < k) {
        int temp = queue.poll();
        count += hm2.getOrDefault(temp, new LinkedList<>()).size();
        result.addAll(hm2.getOrDefault(temp, new LinkedList<>()));
      }
      return result;
  }
}
