class Solution {

  List<List<Integer>> results;

  public List<List<Integer>> subsets(int[] nums) {
    results = new LinkedList<>();
    for (int i = 0; i <= nums.length; i++) {
      List<Integer> temp = new LinkedList<>();
      combinationRecursive(nums, i,0, temp, 0);
    }

    return results;
  }

  private void combinationRecursive(int[] nums, int r, int index, List<Integer> data, int i) {
    if (index == r) {
      results.add(new ArrayList<>(data));
      return;
    }
    if (i >= nums.length) {
      return;
    }
    data.add(nums[i]);
    combinationRecursive(nums, r, index + 1, data, i + 1);
    data.remove(data.size() - 1);
    combinationRecursive(nums, r, index, data, i + 1);
  }
}
