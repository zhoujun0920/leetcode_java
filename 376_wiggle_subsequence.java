// not correct don't know why
// pick up the 
class Solution {
    public int wiggleMaxLength(int[] nums) {
      int n = nums.length;
      if (n <= 1) {
        return n;
      }
      int m = 1;
      int i = 0;
      int j = 1;
      while (j < n && nums[i] == nums[j]) {
          i++;
          j++;
      }
        if (j < n) {
            m = 2;
        } else {
            return m;
        }
      boolean up = true;

      while (j < n) {
        i++;
        j++;
        if (up) {
            if (j < n && nums[i] > nums[j]) {
                m++;
                up = !up;
                continue;
            }
          while (j < n && nums[i] <= nums[j]) {

            j++;
          }
          if (j > n - 1) {
            return m;
          }
          m++;
        } else {
            if (j < n && nums[i] < nums[j]) {
                m++;
                up = !up;
                continue;
            }
          while (j < n && nums[i] >= nums[j]) {
            i = j;
            j++;
          }
          if (j > n - 1) {
            return m;
          }
          m++;
        }
        up = !up;
      }
      return m;
    }
}
