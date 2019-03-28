class Solution {

    List<List<Integer>> results;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
      results = new LinkedList<>();
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
        if (sum > target) {
            return;
        }
        if (sum + candidates[i] <= target) {
            data.add(candidates[i]);
            recursive(candidates, target, sum + candidates[i], data, i);
            data.remove(data.size() - 1);
            recursive(candidates, target, sum, data, i + 1);
        }
    }
}
