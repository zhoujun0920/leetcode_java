class Solution {

    int count = 0;

    public int combinationSum4(int[] nums, int target) {
      Arrays.sort(nums);
      for (int i = 0; i < nums.length; i++) {
        recursive(nums, target, 0, i);
      }

      return count;
    }

    private void recursive(int[] nums, int target, int sum, int i) {
      if (sum == target) {
        count++;
        return;
      }
      if (i >= nums.length) {
        return;
      }
      if (sum + nums[i] <= target) {
        recursive(nums, target, sum + nums[i], i);
        recursive(nums,target, sum, i + 1);
      }
    }
}
