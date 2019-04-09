class Solution {
    public int lengthOfLIS(int[] nums) {
      int m = 0;
      for (int i = 0; i < nums.length; i++) {
        int count = 1;
        int temp = nums[i];
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[j] > temp) {
            count++;
            temp = nums[j];
          }
        }
        m = m > count ? m : count;
      }
      return m;
    }
}
