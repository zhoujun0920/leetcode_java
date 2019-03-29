class Solution {

    List<List<Integer>> results;

    public List<List<Integer>> permute(int[] nums) {
      results = new LinkedList<>();
      recursive(nums, 0, new Integer[nums.length]);
      return results;
    }

    private void recursive(int[] nums, int i, int start, Integer[] data) {
      if (nums.length - start == 1) {
        data[data.length - 1] = nums[start];
        results.add(Arrays.asList());
        return;
      }
      for (int j = start; j < nums.length; j++) {
        if (i != j) {
          data[i] = nums[i];
          recursive(nums, j, data);
        }  
      }
    }
}
