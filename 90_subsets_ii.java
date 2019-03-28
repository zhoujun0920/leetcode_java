class Solution {

    List<List<Integer>> results;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
      results = new LinkedList<>();
       Arrays.sort(nums);
      for (int i = 0; i <= nums.length; i++) {
        List<Integer> data = new LinkedList<>();
        recursive(nums, 0, i, data, 0);
      }
      return results;
    }

    private void recursive(int[] nums, int index, int r, List<Integer> data, int i) {
      if (index == r) {
        results.add(new LinkedList<>(data));
        return;
      }
      if (i >= nums.length) {
        return;
      }
      data.add(nums[index]);
      recursive(nums, index + 1, r, data, i + 1);
      while (i < nums.length && nums[i] == nums[i - 1]) {
        i++;
      }
      data.remove(data.size() - 1);
      recursive(nums, index, r, data, i + 1);
    }
}
