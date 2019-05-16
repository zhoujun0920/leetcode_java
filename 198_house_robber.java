class Solution {
     public int rob(int[] nums) {
        return recursive(nums, 0, new Integer[nums.length]);
    }

     private int recursive(int[] nums, int index, Integer[] memo) {
         if (index >= nums.length) {
             return 0;
         }
         if (index == nums.length - 1) {
             return nums[nums.length - 1];
         }
         if (memo[index] != null) {
             return memo[index];
         }
         return memo[index] = Math.max(nums[index] + recursive(nums, index + 2, memo), recursive(nums, index + 1, memo));
    }
}
