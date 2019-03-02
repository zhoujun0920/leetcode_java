class Solution {
    public int maxProduct(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }
      int m = nums[0];
      int max = nums[0];
      int min = nums[0];
      for (int i = 1; i < nums.length; i++) {
        if (nums[i] < 0) {
          int temp = max;
          max = min;
          min = temp;
        } // switch max and min for negative multiplier
        max = nums[i] > max * nums[i] ? nums[i] : max * nums[i]; //
        min = nums[i] < min * nums[i] ? nums[i] : min * nums[i];
        m = m > max ? m : max;
      }
      return m;
    }
}
