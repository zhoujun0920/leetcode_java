class Solution {

    List<List<Integer>> results;

    public List<List<Integer>> combine(int n, int k) {
      results = new LinkedList<>();
      List<Integer> data = new ArrayList<>();
      recursive(n, k, 0, data, 1);
      return results;
    }

    private void recursive(int n, int k, int index, List<Integer> data, int i) {
      if (index == k) {
        results.add(new LinkedList<>(data));
        return;
      }
      if (i > n) {
        return;
      }
      data.add(i);
      recursive(n, k, index + 1, data, i + 1);
      data.remove(data.size() - 1);
      recursive(n, k, index, data, i + 1);
    }
}
