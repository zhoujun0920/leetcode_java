class Solution {
    public int searchInsert(int[] nums, int target) {
      if (nums.length == 0) {
        return 0;
      }
      if (target <= nums[0]) {
          return 0;
      }
      int fast = 1;
      int slow = 0;
      while (fast < nums.length) {
        if (nums[fast] > target) {
          if (nums[slow] == target) {
            return slow;
          }
          return fast;
        } else if (nums[fast] == target) {
            return fast;
        }
        fast++;
        slow++;
      }
      return nums.length;
    }
}
