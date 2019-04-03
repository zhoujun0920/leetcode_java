class Solution {

    List<List<Integer>> results;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      results = new LinkedList<>();
      Arrays.sort(candidates);
      List<Integer> data = new LinkedList<>();
      recursive(candidates, target, 0, data, 0);
      return results;
    }

    private void recursive(int[] candidates, int target, int sum, List<Integer> data, int i) {
      if (sum == target) {
        results.add(new LinkedList<>(data));
        return;
      }
      if (i >= candidates.length) {
        return;
      }
      if (sum + candidates[i] <= target) {
        data.add(candidates[i]);
        recursive(candidates, target, sum + candidates[i], data, i);
        while(i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
          i++;
        }
        data.remove(data.size() - 1);
        recursive(candidates, target, sum, data, i + 1);
      }
    }
}
