class Solution {

    List<List<Integer>> results;

    public List<List<Integer>> combinationSum3(int k, int n) {
      results = new LinkedList<>();
      List<Integer> data = new LinkedList<>();
      recursive(k, n, 0, 0, data, 1);
      return results;
    }

    private void recursive(int k, int n, int index, int sum, List<Integer> data, int i) {
      if (index > k) {
        return;
      }
      if (index == k && sum == n) {
        results.add(new LinkedList<>(data));
        return;
      }
      if (i < 10 && sum + i <= n) {
        data.add(i);
        recursive(k, n, index + 1, sum + i, data, i + 1);
        data.remove(data.size() - 1);
        if (i + 1 < 10 && sum + i + 1 <= n) {
          recursive(k, n, index, sum, data, i + 1);
        }
      }
    }
}
