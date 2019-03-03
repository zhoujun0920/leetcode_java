class Solution {
    public void moveZeroes(int[] nums) {
      int j = 0;
      for (int i = nums.length - 1; i >= 0; i++) {
        if (nums[i] == 0) {
          continue;
        }
        nums[j++] = nums[i];
      }
      while (j < nums.length - 1) {
        nums[j++] = 0;
      }
    }
}
