class Solution {
    public boolean canJump(int[] nums) {
      int n = nums.length;
      if (n <= 1) {
        return true;
      }
      int i = n - 2;
      while (i >= 0) {
        if (nums[i] == 0) {
          int step = 0;
          while (nums[i - step] < step + 1) {
            step++;
            if (i - step < 0) {
              return false;
            }
          }
          i -= step;
        } else {
          i--;
        }
      }
      return true;
    }
}
