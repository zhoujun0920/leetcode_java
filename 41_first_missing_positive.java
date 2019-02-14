
// using nums[i] as key, using sign as value.
// if nums[i] shows, the value in position nums[i] will be negative.
// if nums[i] == nums.length, make position 0 negative.
// if some where between 1 to nums.length - 1 is positive, then it is the answer.
// if position 0 is positive, then nums.length is the answer.
// if position 0 is negative, then nums.length + 1 is the answer.

class Solution {
  public int firstMissingPositive(int[] nums) {
      int n = nums.length;
      if (n == 0) {
        return 1;
      }
      int contain = 0;
      for (int i : nums) {
        if (i == 1) {
          contain++;
          break;
        }
      }
      if (contain == 0) {
        return 1;
      }
      if (n == 1) {
        return 2;
      }
      for (int i = 0; i < n; i++) {
        if (nums[i] <= 0 || nums[i] > n) {
          nums[i] = 1;
        }
      }
      for (int i = 0; i < n; i++) {
        int position = nums[i] > 0 ? nums[i] : -nums[i];
        if (position == n) {
          nums[0] = nums[0] > 0 ? -nums[0] : nums[0];
        } else {
          nums[position] = nums[position] > 0 ? -nums[position] : nums[position];
        }
      }
      for (int i = 1; i < n; i++) {
        if (nums[i] > 0) {
          return i;
        }
      }
      if (nums[0] > 0) {
        return n;
      }
      return n + 1;
    }
}


1,2,1
