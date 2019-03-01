class Solution {
    public int maxSubArray(int[] nums) {
      int n = nums.length;
      if (n == 1) {
        return nums[0];
      }
      int previousMax = nums[0];
      int m = previousMax;
      for (int i = 1; i < n; i++) {
        previousMax = previousMax > 0 ? (previousMax + nums[i]) : nums[i];
        m = m > previousMax ? m : previousMax;
      }
      return m;
    }

}

[-1,1,-3,4,-1,2,1,-5,4]
