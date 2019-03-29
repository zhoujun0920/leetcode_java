class Solution {

    List<List<Integer>> results;

    public List<List<Integer>> getFactors(int n) {
      results = new LinkedList<>();
      for (int i = 2; i < n / 2; i++) {
        List<Integer> data = new LinkedList<>();
        recursive(n, n, i, data);
      }
      return results;
    }

    private void recursive(int n, int m, int i, List<Integer> data) {
      if (i >= m / 2) {
        if (data.size() > 0 && n > m) {
          data.add(m);
          results.add(new LinkedList<>(data));
        }
        return;
      }
      if (m % i == 0) {
        data.add(i);
        recursive(n, m / i, i, data);
      } else {
        recursive(n, m, i + 1, data);
      }
    }
}
