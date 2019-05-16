class Solution {
    public int rob(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }
      return Math.max(nums[0] + recursive(nums, 2, new Integer[nums.length], false), recursive(nums, 1, new Integer[nums.length], true));
    }

    private int recursive(int[] nums, int index, Integer[] memo, boolean isFree) {
      if (index >= nums.length) {
        return 0;
      }
      if (index == nums.length - 1) {
        if (isFree) {
          return nums[nums.length - 1];
        }
        return 0;
      }
      if (memo[index] != null) {
        return memo[index];
      }
      return memo[index] = Math.max(nums[index] + recursive(nums, index + 2, memo, isFree), recursive(nums, index + 1, memo, isFree));
    }
}
