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


class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
          return 0;
        }
        int max = 0;
        int[] memo = new int[nums.length];
        memo[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int m = 0;
            for (int j = 0 ; j < i; j++) {
                if (nums[i] > nums[j]) {
                    m = Math.max(m, memo[j]);
                }
            }

            memo[i] = m + 1;
            max = max > memo[i] ? max : memo[i];
        }
        return max;
    }
}
